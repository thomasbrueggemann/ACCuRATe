define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"notify",
	"i18n!locales/nls/groups"
], function($, underscore, backbone, Jr, notify, loc) {

	// MAP VIEW
	var BaseGroupView = Jr.View.extend({

		// INITIALIZE
		initialize: function() {

		},

		// INVITE
		invite: function(group, callback) {

			var that = this;
			var id = group["_id"] || group["id"];

			// request code from API
			$.post(window.host + "/devices/invite/code", {
				"group": id
			}, function(data) {

				// houston, we have a code
				if (data.success == true && data.code.length > 0) {

					var msg = loc.inviteMessage_part1 + " " + group.name + ". " + loc.inviteMessage_part2 + " " + data.code + " " + loc.inviteMessage_part3 + " " + loc.inviteMessage_part4;

					// post code to social sharing plugin
					window.plugins.socialsharing.share(msg, loc.inviteSubject, null, null,

						// success
						function() {

							return callback({
								"code": data.code,
								"ticket": data.ticket
							});
						},

						// error
						function() {
							notify.error(loc.inviteError);
						}
					);
				} else {
					notify.error(loc.inviteError);
				}
			})
				.fail(function() {

					// bad gateway
					if (xhr.status == 502) {
						notify.badGateway();
						return;
					}

					notify.error(loc.inviteError);
				});
		},

		// REMOVE MEMBER
		removeMember: function(e) {

			var $e = $(e.target);
			if (!$e.data("groupid")) $e = $e.parents("[data-groupid]");

			// read group and member id
			var groupid = $e.data("groupid");
			var memberid = $e.data("memberid");

			// abort if no group or member id was found
			if (!groupid || groupid.length <= 0 || !memberid || memberid.length <= 0) return;

			var data = {
				"did": memberid,
				"groups": {}
			};

			data["groups"][groupid] = "false";

			notify.confirm({
				"title": loc.delMemberTitle,
				"message": loc.delMemberMessage
			}, function(confirmation) {

				if (confirmation === true) {

					// leave group
					$.post(window.host + "/devices/setgroups", data, function(groups) {

						// remove from UIs
						$e.remove();
					})
						.fail(function(xhr, textStatus, errorThrown) {

							// bad gateway
							if (xhr.status == 502) {
								notify.badGateway();
								return;
							}

							var data = JSON.parse(xhr.responseText);

							if (data.error) {
								notify.error(data.error);
							}
						});
				}
			});
		},

		// REMOVE INVITATION
		removeInvitation: function(e) {

			var $e = $(e.target);
			if (!$e.data("ticketid")) $e = $e.parents("[data-ticketid]");

			notify.confirm({
				"title": loc.delInvitationTitle,
				"message": loc.delInvitationMessage
			}, function(confirmation) {

				if (confirmation === true) {

					// delete ticket
					$.post(window.host + "/users/tickets/delete", {
						"tid": $e.data("ticketid")
					}, function(result) {

						// ticket deletion complete?
						if (result.success == true) {

							// ticket was deleted, remove the element from view
							$e.remove();
						} else {
							notify.error(loc.memberDeleteError);
						}

					})
						.fail(function(xhr, textStatus, errorThrown) {

							// bad gateway
							if (xhr.status == 502) {
								notify.badGateway();
								return;
							}

							var data = JSON.parse(xhr.responseText);

							if (data.error) {
								notify.error(data.error);
							}
						});
				}
			});
		}
	});

	return BaseGroupView;
});
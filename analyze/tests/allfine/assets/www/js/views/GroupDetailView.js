define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"ratchet",
	"views/BaseGroupView",
	"notify",
	"text!templates/groupDetail.html",
	"text!templates/groupInvitationItem.html",
	"i18n!js/locales/nls/groups.js",
	"collections/GroupCollection"
], function($, _, backbone, Jr, ratchet, BaseGroupView, notify, groupDetailTpl, groupInvitationItemTpl, loc, GroupCollection) {

	var GroupDetailView = BaseGroupView.extend({

		events: {
			"click [data-return]": "returnTo",
			"click [data-action='leaveGroup']": "leaveGroup",
			"click [data-action='deleteGroup']": "deleteGroup",
			"click [data-action='removeMember']": "removeMember",
			"click [data-action='removeInvitation']": "removeInvitation",
			"touchend #addMember": "inviteMember"
		},

		// INITIALIZE
		initialize: function(args) {
			this.id = args.id;
			this.collection = new GroupCollection();
			this.collection.fetch();
		},

		// RENDER
		render: function() {
			if (typeof(analytics) !== "undefined") analytics.trackView("Group Detail View");

			// find group that matches this id
			this.group = this.collection.get(this.id);

			// order members by ownership, so that "YOU" is always on top
			var members = this.group.get("members");
			members.sort(function(a, b) {

				console.log(JSON.stringify(a));
				var checkA = (a["id"] != window.senseId) ? 1 : 0;
				var checkB = (b["id"] != window.senseId) ? 1 : 0;
				return checkB < checkA;
			});

			this.group.set("members", members);

			console.log(JSON.stringify(this.group.get("tickets")));

			var t = _.template(groupDetailTpl)({
				"group": this.group,
				"loc": loc,
				"senseId": window.senseId
			});

			this.$el.html(t);

			return this;
		},

		// UNLOAD
		unload: function() {
			this.undelegateEvents();
		},

		// DELETE GROUP
		deleteGroup: function(e) {
			var that = this;
			var groupid = $(e.target).data("groupid");

			if (!groupid || groupid.length <= 0) {
				groupid = $(e.target).parents("[data-groupid]").data("groupid");
			}

			if (!groupid || groupid.length <= 0) return;

			// user is offline
			if (navigator.connection.type == Connection.NONE) {
				notify.error(loc.offlineGroup);
				return;
			}

			notify.confirm({
				"title": loc.delGroupTitle,
				"message": loc.delGroupMessage
			}, function(confirmation) {

				if (confirmation === true) {

					// delete group on remote API
					$.post(window.host + "/groups/delete", {
						"id": groupid
					}, function(groups) {

						// remove group from local collection
						var grp = that.collection.get(groupid);
						that.collection.remove(grp);

						// navigate to overview page
						// return to last screen
						Jr.Navigator.navigate("groups", {
							trigger: true,
							animation: {
								type: Jr.Navigator.animations.SLIDE_STACK,
								direction: Jr.Navigator.directions.RIGHT
							}
						});
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

		// LEAVE GROUP
		leaveGroup: function(e) {
			var that = this;
			var groupid = $(e.target).data("groupid");

			if (!groupid || groupid.length <= 0) {
				groupid = $(e.target).parents("[data-groupid]").data("groupid");
			}

			if (!groupid || groupid.length <= 0) return;

			// user is offline
			if (navigator.connection.type == Connection.NONE) {
				notify.error(loc.offlineGroup);
				return;
			}

			notify.confirm({
				"title": loc.leaveGroupTitle,
				"message": loc.leaveGroupMessage
			}, function(confirmation) {

				if (confirmation === true) {

					var grps = {};
					grps[groupid] = "false";

					// delete group on remote API
					$.post(window.host + "/devices/setgroups", {
						"did": window.senseId,
						"groups": grps
					}, function(groups) {

						// remove group from local collection
						var grp = that.collection.get(groupid);
						that.collection.remove(grp);

						// navigate to overview page
						// return to last screen
						Jr.Navigator.navigate("groups", {
							trigger: true,
							animation: {
								type: Jr.Navigator.animations.SLIDE_STACK,
								direction: Jr.Navigator.directions.RIGHT
							}
						});
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

		// RETURN TO
		returnTo: function(e) {
			var groupname = $("#groupname").val();
			var groupid = $("#groupname").data("groupid");

			// save the group name while leaving detail view
			if (groupname && groupname.length > 0 && groupid && groupid.length > 0) {
				$.post(window.host + "/groups/save", {
					"id": groupid,
					"name": groupname
				});
			}

			// find return target
			var $e = $(e.target);
			if (!$e.data("return")) $e = $e.parent();

			// return to last active tab if this is not a settings return
			var r = $e.data("return");
			if (r.indexOf("settings") === -1) {
				r = window.router.tabbar.getActive();
			}

			// return to last screen
			Jr.Navigator.navigate(r, {
				trigger: true,
				animation: {
					type: Jr.Navigator.animations.SLIDE_STACK,
					direction: Jr.Navigator.directions.RIGHT
				}
			});
		},

		// INVITE MEMBER
		inviteMember: function() {

			var that = this;

			// user is offline
			if (navigator.connection.type == Connection.NONE) {
				notify.error(loc.offlineGroup);
				return;
			}

			this.invite({
				"id": this.group.get("id"),
				"name": this.group.get("name")
			}, function(e) {

				// create pending innvitation item
				var t = _.template(groupInvitationItemTpl)({
					"groupId": that.group.get("id"),
					"loc": loc,
					"ticketId": e.ticket
				});

				// add to list
				that.$el.find("#addMember").parent().before(t);
			});
		}
	});

	return GroupDetailView;
});
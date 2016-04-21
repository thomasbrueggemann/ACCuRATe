define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"notify",
	"ratchet",
	"text!templates/groups.html",
	"text!templates/groupList.html",
	"i18n!js/locales/nls/groups.js",
	"collections/GroupCollection"
], function($, _, backbone, Jr, notify, ratchet, groupsTpl, groupListTpl, loc, GroupCollection) {

	var GroupsView = Jr.View.extend({

		groups: null,

		events: {
			"touchend [data-navigate]": "goto",
			"touchend [data-action='acceptInvite']": "inviteCode",
			"touchend #groups-segements > .control-item": "switchedSegments"
		},

		// INITIALIZE
		initialize: function() {
			this.collection = new GroupCollection();
		},

		// RENDER
		render: function() {

			if (typeof(analytics) !== "undefined") analytics.trackView("Groups View");

			var t = _.template(groupsTpl)({
				"loc": loc
			});

			this.$el.html(t);
			this.loadGroups();

			return this;
		},

		// UNLOAD
		unload: function() {
			this.undelegateEvents();
		},

		// LOAD GROUPS
		loadGroups: function() {
			var that = this;

			// load all groups of user
			$.get(window.host + "/groups/device/" + window.senseId + "?members=true", function(groups) {

				that.groups = groups;
				var t = _.template(groupListTpl)({
					"groups": groups,
					"loc": loc
				});

				if (!that.collection) {
					that.collection = new GroupCollection();
				} else {
					that.collection.reset();
				}

				// fill models with groups
				for (var i in that.groups) {
					var members = [];

					// fill members of model
					for (var j in that.groups[i]["members"]) {
						members.push({
							"id": that.groups[i]["members"][j]["_id"],
							"name": that.groups[i]["members"][j]["name"]
						});
					}

					var tickets = [];

					// fill tickets of group
					for (var k in that.groups[i]["tickets"]) {
						tickets.push({
							"id": that.groups[i]["tickets"][k]["_id"]
						});
					}

					// add new group to collection
					that.collection.create({
						"id": that.groups[i]["_id"],
						"name": that.groups[i]["name"],
						"owner": that.groups[i]["owner"],
						"members": members,
						"tickets": tickets
					});
				}

				$("#groupListContainer").html(t);

				window.setTimeout(function() {
					that.restoreActiveSegment();
				}, 100);

			}).fail(function(xhr, textStatus, errorThrown) {

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
		},

		// INVITE CODE
		inviteCode: function() {

			var that = this;

			// prompt user for code
			navigator.notification.prompt(
				loc.pleaseInviteCode,
				function(results) {

					var code = results.input1;

					if (results.buttonIndex == 2 && code.length > 0) {

						var uuid = device.uuid;
						var platform = device.platform;
						var model = device.model;
						var version = device.version;

						$.post(window.host + "/devices/invite/accept", {
							"uuid": uuid,
							"platform": platform,
							"model": model,
							"version": version,
							"code": code
						}, function(data) {
							if (typeof(data) === "string" || data instanceof String) data = JSON.parse(data);

							// check if response data is valid
							if (data && data.success == true) {

								that.loadGroups();

							} else {
								notify.alert({
									title: loc.errorTitle,
									message: loc.inviteError
								});
							}

						}).fail(function(xhr, errorType, error) {

							var json = $.parseJSON(xhr.responseText);

							if (json && json.error) {
								notify.alert({
									title: loc.errorTitle,
									message: json.error
								});
							} else {
								notify.alert({
									title: loc.errorTitle,
									message: loc.inviteError
								});
							}
						});
					}
				},
				loc.invitation, // title
				[loc.cancel, loc.accept], // buttonLabels
				"" // default
			);
		},

		// GOTO
		goto: function(e) {
			var $e = $(e.target);
			if (!$e.data("navigate")) $e = $e.parent();

			console.log($e.data("navigate"));

			Jr.Navigator.navigate($e.data("navigate"), {
				trigger: true,
				animation: {
					type: Jr.Navigator.animations.SLIDE_STACK,
					direction: Jr.Navigator.directions.LEFT
				}
			});
		},

		// SWITCHED SEGMENTS
		switchedSegments: function(e) {

			window.setTimeout(function() {

				if ($("[href='#ownGroups']").hasClass("active")) {
					localStorage.setItem("groupActiveSegment", "ownGroups");
				} else {
					localStorage.setItem("groupActiveSegment", "invitedGroups");
				}
			}, 150);
		},

		// RESTORE ACTIVE SEGMENT
		restoreActiveSegment: function() {
			var href = localStorage.getItem("groupActiveSegment") || "ownGroups";
			console.log(localStorage.getItem("groupActiveSegment"));

			// set active segment
			$(".control-item").removeClass("active");
			$("[href='#" + href + "']").addClass("active");

			// set active body
			$(".control-content").removeClass("active");
			$("#" + href).addClass("active");
		}
	});

	return GroupsView;
});
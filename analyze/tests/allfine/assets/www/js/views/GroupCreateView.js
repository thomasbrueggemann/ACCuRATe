define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"ratchet",
	"views/BaseGroupView",
	"text!templates/groupCreate.html",
	"text!templates/groupInvitationItem.html",
	"i18n!js/locales/nls/groups.js"
], function($, _, backbone, Jr, ratchet, BaseGroupView, groupCreateTpl, groupInvitationItemTpl, loc) {

	var GroupCreateView = BaseGroupView.extend({

		action: "name",

		events: {
			"touchend [data-return]": "goback",
			"keyup #newGroupName": "validateName",
			"touchend #nextLink": "createGroup",
			"touchend #readyLink": "ready",
			"touchend #backLink": "ready",
			"touchend #inviteMember": "inviteMember"
		},

		// INITIALIZE
		initialize: function(args) {
			GroupCreateView.__super__.initialize.call(this);
			this.action = args.action || "name";
		},

		// RENDER
		render: function() {
			var that = this;

			var t = _.template(groupCreateTpl)({
				"loc": loc,
				"action": this.action,
				"group": localStorage.getObject("newGroup")
			});

			this.$el.html(t);

			window.setTimeout(function() {

				// name
				if (that.action == "name") {
					$("#newGroupName").focus();
				}

			}, 500);

			return this;
		},

		// UNLOAD
		unload: function() {

			this.undelegateEvents();
		},

		// GO BACK
		goback: function(e) {
			var $e = $(e.target);
			if (!$e.data("return")) $e = $e.parent();

			console.log($e.data("return"));

			Jr.Navigator.navigate($e.data("return"), {
				trigger: true,
				animation: {
					type: Jr.Navigator.animations.SLIDE_STACK,
					direction: Jr.Navigator.directions.RIGHT
				}
			});
		},

		// VALIDATE NAME
		validateName: function() {
			var name = $("#newGroupName").val();
			var $nl = $("#nextLink");

			if (name.length > 0) {
				$nl.removeClass("btn-disabled");
				$nl.data("navigate", "group/create/members");
			} else {
				$nl.addClass("btn-disabled");
				$nl.data("navigate", "");
			}
		},

		// CREATE GROUP
		createGroup: function(e) {

			$("#newGroupName").blur();

			// check if this is a valid creation
			var $e = $(e.target);
			if (!$e.data("navigate")) $e = $e.parent();
			if ($e.data("navigate").length <= 0) return;

			// user is offline
			if (navigator.connection.type == Connection.NONE) {
				notify.error(loc.offlineGroup);
				return;
			}

			// create the group with API call
			$.post(window.host + "/groups/save", {
				"name": $("#newGroupName").val(),
				"addAllDevicesFromUser": true
			}, function(data) {

				if (data.success == true) {
					localStorage.setObject("newGroup", data.group);

					Jr.Navigator.navigate($e.data("navigate"), {
						trigger: true,
						animation: {
							type: Jr.Navigator.animations.SLIDE_STACK,
							direction: Jr.Navigator.directions.LEFT
						}
					});
				} else {
					notify.error("Die Gruppe konnte nicht angelegt werden!");
				}

			}).fail(function() {
				notify.error("Die Gruppe konnte nicht angelegt werden!");
			});
		},

		// READY
		ready: function() {

			localStorage.setObject("newGroup", {});

			// go back to groups overview
			Jr.Navigator.navigate("groups", {
				trigger: true,
				animation: {
					type: Jr.Navigator.animations.SLIDE_STACK,
					direction: Jr.Navigator.directions.RIGHT
				}
			});
		},

		// INVITE MEMBER
		inviteMember: function() {
			var group = localStorage.getObject("newGroup");
			var that = this;

			// user is offline
			if (navigator.connection.type == Connection.NONE) {
				notify.error(loc.offlineGroup);
				return;
			}

			this.invite(group, function(e) {

				// create pending innvitation item
				var t = _.template(groupInvitationItemTpl)({
					"groupId": group["id"],
					"loc": loc,
					"ticketId": e.ticket
				});

				// add to list
				that.$el.find("#inviteMember").parent().before(t);
			});
		}
	});

	return GroupCreateView;

});
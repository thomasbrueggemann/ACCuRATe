define([
	"jquery",
	"underscore-min",
	"backbone-min",
	"junior",
	"notify",
	"leaflet",
	"leaflet.label",
	"leaflet.vector-markers",
	"randomColor",
	"oms",
	"text!templates/mapPopup.html",
	"text!templates/photoModal.html",
	"text!templates/logbookPopup.html",
	"i18n!locales/nls/map",
	"i18n!js/locales/nls/tabbar.js"
], function($, underscore, backbone, Jr, notify, leaflet, leafletlabel, awesomemarker,
	randomColor, oms, popupTpl, photoModalTpl, logbookTpl, loc, tabbarLoc) {

	// ALLFINE MARKER
	L.AllFineMarker = L.Marker.extend({
		options: {
			type: "user",
			id: null,
			text: null
		}
	});

	// MAP VIEW
	var BaseMapView = Jr.View.extend({

		map: null,
		oms: null,
		path: {},
		allCoords: [],
		photos: [],
		logbooks: [],
		labels: {},
		colors: {},

		// INITIALIZE
		initialize: function() {

			var that = this;

			// delete photo click
			$(document).on("click", ".delete-photo", function(e) {
				that.deletePhoto(e);
			});

			$(document).on("click", ".delete-logbook", function(e) {
				that.deleteLogbook(e);
			});
		},

		// FIT PATHS
		fitPaths: function() {
			if (this.allCoords.length > 0) {
				this.map.fitBounds(this.allCoords);
			}
		},

		// UNLOAD
		unload: function() {
			$(document).off("click", ".delete-logbook");
			$(document).off("click", ".delete-photo");
		},

		// CLEAR PATHS
		clearPaths: function() {
			for (var path in this.path) {
				this.map.removeLayer(this.path[path]);
			}

			for (var label in this.labels) {
				this.map.removeLayer(this.labels[label]);
			}

			for (var photo in this.photos) {
				this.map.removeLayer(this.photos[photo]);
			}

			for (var logbook in this.logbooks) {
				this.map.removeLayer(this.logbooks[logbook]);
			}

			this.path = {};
			this.labels = {};
			this.allCoords = [];
			this.photos = [];
			this.logbooks = [];
		},

		// INIT SPIDER LEGS
		initSpiderLegs: function() {
			var that = this;

			if (this.oms != null) this.oms.unspiderfy();
			this.oms = new OverlappingMarkerSpiderfier(this.map, {
				nearbyDistance: 50,
				legWeight: 3,
				keepSpiderfied: true
			});

			var popup = new L.Popup();
			this.oms.addListener("click", function(marker) {

				popup.setContent("<div class=\"popup-loader\"><i class=\"fa fa-circle-o-notch fa-spin\"></i></div>");
				popup.setLatLng(marker.getLatLng());
				that.map.openPopup(popup);

				switch (marker.options.type) {

					// USER
					case "user":

						// try to fetch last boat position
						$.get(window.host + "/positions/device/" + marker.options.id + "/last", function(pos) {

							console.log(pos);

							var p = _.template(popupTpl)({
								"loc": loc,
								"position": pos,
								"name": marker.label._prevContent,
							});

							popup.setContent(p);
						})
							.fail(function(xhr, textStatus, errorThrown) {

								// bad gateway
								if (xhr.status == 502) {
									notify.badGateway();
									return;
								}

								var data = JSON.parse(xhr.responseText);

								if (data.error) {
									notify.error(loc.deviceInfoError);
								}
							});
						break;


						// LOGBOOK
					case "logbook":

						var id = marker.options.id.split("_");

						// try to fetch last boat position
						$.get(window.host + "/positions/logbook/" + id[0] + "/" + id[1], function(logbook) {

							var p = _.template(logbookTpl)({
								"loc": tabbarLoc,
								"logbook": logbook,
								"usr": localStorage.getItem("userid")
							});

							popup.setContent(p);
							popup.setLatLng(marker.getLatLng());
							that.map.openPopup(popup);
						})
							.fail(function(xhr, textStatus, errorThrown) {

								// bad gateway
								if (xhr.status == 502) {
									notify.badGateway();
									return;
								}

								var data = JSON.parse(xhr.responseText);

								if (data.error) {
									notify.error(loc.logbookInfoError);
								}
							});

						break;

						// UPLOAD
					case "upload":

						popup.setContent("<img src='" + window.host + "/positions/upload/" + marker.options.id + "' width='200' />");
						popup.setLatLng(marker.getLatLng());
						that.map.openPopup(popup);
						break;
				}
			});
		},

		// ADD PATH
		addPath: function(data) {

			var that = this;

			if (!data || !data.positions || data.positions.length <= 0) return;

			// delete old path
			if (this.path[data.device._id]) {
				this.map.removeLayer(this.path);
				this.path[data.device._id] = null;
			}

			// split coords string
			var coords = [];
			var lastValid = null;
			var splitted = data.positions.split(";");
			for (var i = splitted.length - 1; i >= 0; i--) {
				var coord = splitted[i].split(",");
				if (coord.length == 2) {
					lastValid = coord;

					coords.push(L.latLng(parseFloat(coord[1]), parseFloat(coord[0])));
				}
			}

			var color = this.colors[data.device._id] = randomColor({
				luminosity: "dark"
			});

			// add boat at the end of the path
			this.addLabelMarker({
				name: data.device.name,
				pos: lastValid,
				id: data.device._id
			}, color);

			// create polyline form coords
			this.path[data.device._id] = L.polyline(coords, {
				color: color,
				smoothFactor: 5,
				opacity: 0.6
			});
			this.path[data.device._id].addTo(this.map);

			// loop over uploads dictionary
			for (var u in data.uploads) {
				this.addUploadMarker(u, data.uploads[u], color);
			}

			// loop over logbook dictionary
			for (var l in data.logbooks) {
				this.addLogbookMarker(data.device._id, l, data.logbooks[l], color);
			}

			// store all corrds to create bounding box
			this.allCoords = this.allCoords.concat(coords);
		},

		// ADD LABEL
		addLabelMarker: function(data, color) {

			var that = this;

			var icon = L.VectorMarkers.icon({
				icon: "user",
				markerColor: color,
				extraClasses: "fa-2x",
				options: {
					popupAnchor: [0, -20]
				}
			});

			var l = new L.AllFineMarker([parseFloat(data.pos[1]), parseFloat(data.pos[0])])
				.setIcon(icon)
				.bindLabel(data.name, {
					noHide: true,
					direction: "auto"
				})
				.addTo(this.map);

			this.oms.addMarker(l);

			//l.options.alt = data.id;
			l.options.id = data.id;
			l.options.type = "user";

			this.labels[data.id] = l;
		},

		// ADD UPLOAD MARKER
		addUploadMarker: function(uploadId, coords, color) {

			var data = coords.split(",");
			var that = this;

			var icon = L.VectorMarkers.icon({
				icon: "camera",
				markerColor: color
			});

			var l = new L.AllFineMarker([parseFloat(data[1]), parseFloat(data[0])])
				.setIcon(icon)
				.addTo(this.map);

			l.options.id = uploadId;
			l.options.type = "upload";

			this.oms.addMarker(l);
			this.photos.push(l);
		},

		// ADD LOGBOOK MARKER
		addLogbookMarker: function(senseid, logbookid, coords, color) {

			var exists = this.logbooks.filter(function(book) {
				return (book.options.id === senseid + "_" + logbookid);
			});

			if (exists.length === 0) {

				var data = coords.split(",");
				var that = this;

				var icon = L.VectorMarkers.icon({
					icon: "comment",
					markerColor: color
				});

				var l = L.marker([parseFloat(data[1]), parseFloat(data[0])])
					.setIcon(icon)
					.addTo(this.map);

				l.options.id = senseid + "_" + logbookid;
				l.options.type = "logbook";

				this.oms.addMarker(l);
				this.logbooks.push(l);
			}
		},

		// DELETE PHOTO
		deletePhoto: function(e) {
			var that = this;
			var $e = $(e.currentTarget).parents("tr");
			var uid = $e.data("uid");

			// ask the user if he is sure about deletion
			notify.del(loc.confirm, function(amISure) {
				if (amISure == true) {

					$.post(window.host + "/positions/upload/delete", {
						"uid": uid
					}, function(data) {

						// deleteion successful, remove the marker from view array and
						// close the popup
						for (var p in that.photos) {
							console.log(that.photos[p].options.alt, uid);

							if (that.photos[p].options.alt == uid) {

								console.log("removeLayer");
								that.map.removeLayer(that.photos[p]);
								that.photos.splice(p, 1);
								$e.remove();
								break;
							}
						}

						// no photos in modal anymore, close modal
						if ($(".photos-table").find("tr").length == 0) {
							$("#photos").modal("hide");
						}

					}).fail(function(xhr, textStatus, errorThrown) {

						// bad gateway
						if (xhr.status == 502) {
							notify.badGateway();
							return;
						}

						var data = JSON.parse(xhr.responseText);

						if (data.error) {
							notify.error(loc.photoDeleteError);
						}
					});
				}
			});
		},

		// DELETE LOGBOOK
		deleteLogbook: function(e) {
			var that = this;
			$e = $(e.currentTarget);
			var did = $e.data("did");
			var lid = $e.data("lid");

			console.log(did, lid);

			// ask the user if he is sure about deletion
			notify.del(loc.confirm, function(amISure) {
				if (amISure == true) {

					$.post(window.host + "/positions/logbook/delete", {
						"did": did,
						"lid": lid
					}, function(data) {

						// deleteion successful, remove the marker from view array and
						// close the popup
						for (var p in that.logbooks) {

							if (that.logbooks[p].options.alt == did + "_" + lid) {

								that.map.removeLayer(that.logbooks[p]);
								that.logbooks.splice(p, 1);
								break;
							}
						}

						$("#map").trigger("click");

					}).fail(function(xhr, textStatus, errorThrown) {

						// bad gateway
						if (xhr.status == 502) {
							notify.badGateway();
							return;
						}

						var data = JSON.parse(xhr.responseText);

						if (data.error) {
							notify.error(loc.photoDeleteError);
						}
					});
				}
			});
		}
	});

	return BaseMapView;
});
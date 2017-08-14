const fs = require("fs");

// check if input file is set
if (process.argv.length !== 3) {
	console.error("Usage: node interpret ./pathToJson");
	return;
}

// load file
fs.readFile(process.argv[2], "utf8", function(err, data) {
	if (err) {
		return console.log(err);
	}

	// parse json
	var json = JSON.parse(data);

	// count found
	var found = json.filter(f => {
		return f.found === true;
	});
	console.log("found", found.length);

	// calculate certainty
	var certainty = found.map(f => {
		switch (f.probability) {
			case "LOW":
				return 0.25;
			case "MEDIUM":
				return 0.5;
			case "HIGH":
				return 0.75;
		}
	});

	console.log("certainty", certainty.reduce((pv, cv) => pv + cv, 0));
});

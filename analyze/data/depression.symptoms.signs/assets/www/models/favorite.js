/**
 * Created by Leonid on 4/21/14.
 */
var FavoriteViewModel = kendo.observable({
    messageDataSource: {},
    init: function(e){
    },
    show: function(){
        $.ajax({
            url: "data/freemessages.txt"
        }).done(function(data) {
            if(typeof (localStorage.favoritelist) == "undefined"){
                localStorage.favoritelist = "[]";
            }
            var favoritelist = eval(localStorage.favoritelist);
            var split = data.split("\n");
            console.log(split);
            FavoriteViewModel.messageDataSource = new kendo.data.DataSource();
            for(var i=0;i<split.length;i++){
                if(split[i]!=""){
                    for(var j=0;j<favoritelist.length;j++){
                        if(favoritelist[j] == i)
                            FavoriteViewModel.messageDataSource.add({id:i,message:split[i]});
                    }
                }
            }
			$.ajax({
				url: "data/paidmessages.txt"
			}).done(function(data) {
				if(typeof (localStorage.paidfavoritelist) == "undefined"){
					localStorage.paidfavoritelist = "[]";
				}
				var favoritelist = eval(localStorage.paidfavoritelist);
				var split = data.split("\n");
				console.log(split);
				for(var i=0;i<split.length;i++){
					if(split[i]!=""){
						for(var j=0;j<favoritelist.length;j++){
							if(favoritelist[j] == i)
								FavoriteViewModel.messageDataSource.add({id:(i+1000),message:split[i]});		// I'm really sorry, this is the best way possible. Just hope that number of free messages doesn't exceed 1000////	
						}
					}
				}
				var result;
                if (FavoriteViewModel.messageDataSource.data().length != 0)
                {
					var template = kendo.template($("#favoriteflirting-template").text());
					result = template(FavoriteViewModel.messageDataSource.data());
                }
                else
                    result = '<div align="center">There are currently no favorite messages. Please go back to your messages, and add your favorite messages by clicking star in the right corner.</div>';
				$("#favoriteflirting-list").html(result);   
			});
		});
		
    },
    onBack: function(){
    	document.getElementById('cStatus').value='0'; 
        location.href = "#./views/firstmenu/index.html";
    },
    onShare: function(index){
        console.log(index);
        console.log(FavoriteViewModel.messageDataSource);
        console.log(FavoriteViewModel.messageDataSource.get(index).message);
        window.plugins.socialsharing.share(FavoriteViewModel.messageDataSource.get(index).message);
    },
    toggleFavorite:function(obj,index){
        if(obj.attr("class") == "favorite"){
            obj.removeClass('favorite');
            obj.addClass('right');
            FavoriteViewModel.removeFromFavorites(index);
        }
        else{
            obj.removeClass('right');
            obj.addClass('favorite');
            FavoriteViewModel.addToFavorites(index);
        }
    },
    addToFavorites: function(index){
        console.log("add="+index);
        var favoritelist = eval((index < 1000)?localStorage.favoritelist:localStorage.paidfavoritelist);
        favoritelist.push(index % 1000);
        var str = "[";
        for(var i=0;i<favoritelist.length;i++){
            str += favoritelist[i];
            if(i != favoritelist.length-1){
                str += ",";
            }
        }
        str += "]";
		if (index < 1000)
			localStorage.favoritelist = str;	
		else
			localStorage.paidfavoritelist = str;	
    },
    removeFromFavorites: function(index){
        console.log("remove = "+index);
        var favoritelist = eval((index < 1000)?localStorage.favoritelist:localStorage.paidfavoritelist);
        var pos = -1;
        for(var i=0;i<favoritelist.length;i++){
            if(favoritelist[i] == index % 1000){
                pos = i;
            }
        }
        favoritelist.splice(pos,1);
        var str = "[";
        for(var i=0;i<favoritelist.length;i++){
            str += favoritelist[i];
            if(i != favoritelist.length-1){
                str += ",";
            }
        }
        str += "]";
		if (index < 1000)
			localStorage.favoritelist = str;	
		else
			localStorage.paidfavoritelist = str;	
    }
});
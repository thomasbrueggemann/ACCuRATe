/**
 * Created by Leonid on 4/21/14.
 */
var FreeFlirtingViewModel = kendo.observable({
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
            FreeFlirtingViewModel.messageDataSource = new kendo.data.DataSource();
            for(var i=0;i<split.length;i++){
                if(split[i]!=""){
                    var flag = false;
                    for(var j=0;j<favoritelist.length;j++){
                        if(favoritelist[j] == i)
                            flag = true;
                    }
                    FreeFlirtingViewModel.messageDataSource.add({id:i,message:split[i],isfavorite:flag});
                }
            }
            var template = kendo.template($("#freeflirting-template").text());
            var result = template(FreeFlirtingViewModel.messageDataSource.data());
            $("#freeflirting-list").html(result);
        });
    },
    onBack: function(){
    	document.getElementById('cStatus').value='0';    	
        location.href = "#./views/firstmenu/index.html";
    },
    onMoreApp: function(){    	
    	window.localStorage.setItem("b_Pass", "true");
    	if (device.platform == "iOS") {
		       window.open('itms-apps://itunes.com/apps/chrisbechard'); // or itms:// 
		} else if (device.platform == "Android") {
		       window.open('market://search?q=pub:Text+Examples');
 		} else {
               window.open('zune:search?publisher=Text Examples');
		}
    },
    onShare: function(index){
        console.log(index);
        console.log(FreeFlirtingViewModel.messageDataSource.get(index).message);
        window.plugins.socialsharing.share(FreeFlirtingViewModel.messageDataSource.get(index).message);
    },
    addToFavorites: function(index){
        console.log("add="+index);
        var favoritelist = eval(localStorage.favoritelist);
        favoritelist.push(index);
        var str = "[";
        for(var i=0;i<favoritelist.length;i++){
            str += favoritelist[i];
            if(i != favoritelist.length-1){
                str += ",";
            }
        }
        str += "]";
        localStorage.favoritelist = str;
        FreeFlirtingViewModel.show();
    },
    removeFromFavorites: function(index){
        console.log("remove = "+index);
        var favoritelist = eval(localStorage.favoritelist);
        var pos = -1;
        for(var i=0;i<favoritelist.length;i++){
            if(favoritelist[i] == index){
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
        localStorage.favoritelist = str;
        FreeFlirtingViewModel.show();
    }
});
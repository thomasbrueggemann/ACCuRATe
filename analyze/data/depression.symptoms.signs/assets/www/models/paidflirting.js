/**
 * Created by Leonid on 4/25/14.
 */
var PaidFlirtingViewModel = kendo.observable({
    messageDataSource: {},
    init: function(e){
    },
    show: function(){
        $.ajax({
            url: "data/paidmessages.txt"
        }).done(function(data) {
                if(typeof (localStorage.paidfavoritelist) == "undefined"){
                    localStorage.paidfavoritelist = "[]";
                }
                var favoritelist = eval(localStorage.paidfavoritelist);
                var split = data.split("\n");
                console.log(split);
                PaidFlirtingViewModel.messageDataSource = new kendo.data.DataSource();
                for(var i=0;i<split.length;i++){
                    if(split[i]!=""){
                        var flag = false;
                        for(var j=0;j<favoritelist.length;j++){
                            if(favoritelist[j] == i)
                                flag = true;
                        }
                        PaidFlirtingViewModel.messageDataSource.add({id:i,message:split[i],isfavorite:flag});
                    }
                }
                var template = kendo.template($("#paidflirting-template").text());
                var result = template(PaidFlirtingViewModel.messageDataSource.data());
                $("#paidflirting-list").html(result);
            });
    },
    onBack: function(){
    	document.getElementById('cStatus').value='0'; 
        location.href = "#./views/firstmenu/index.html";
    },
    onShare: function(index){
        console.log(index);
        console.log(PaidFlirtingViewModel.messageDataSource.get(index).message);
        window.plugins.socialsharing.share(PaidFlirtingViewModel.messageDataSource.get(index).message);
    },
    addToFavorites: function(index){
        console.log("add="+index);
        var favoritelist = eval(localStorage.paidfavoritelist);
        favoritelist.push(index);
        var str = "[";
        for(var i=0;i<favoritelist.length;i++){
            str += favoritelist[i];
            if(i != favoritelist.length-1){
                str += ",";
            }
        }
        str += "]";
        localStorage.paidfavoritelist = str;
        PaidFlirtingViewModel.show();
    },
    removeFromFavorites: function(index){
        console.log("remove = "+index);
        var favoritelist = eval(localStorage.paidfavoritelist);
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
        localStorage.paidfavoritelist = str;
        PaidFlirtingViewModel.show();
    }
});
/**
 * Created by Leonid on 4/21/14.
 */
var FirstMenuViewModel = kendo.observable({
    init: function(e){
    },
    show: function(){

        app.showAdWhenNotPurchased();
        if(window.localStorage.getItem("AppPurchased") == "1"){
            $(".menu-item.locked").attr("class","menu-item");
                                          $(".restore-button").attr("style","display: none");
        }
                                          if(device.platform != "iOS")
                                          $(".restore-button").attr("style","display: none");

        $(".outer").height($(window).height());
        $.ajax({
            url: "data/freemessages.txt"
        }).done(function(data) {
            var count = 0;
            var split = data.split("\n");
            console.log(split);
            for(var i=0;i<split.length;i++){
                if(split[i]!=""){
                    count++;
                }
            }
            $("[id=freeflirtingcount]").text(count);
        });
        $.ajax({
            url: "data/paidmessages.txt"
        }).done(function(data) {
            var count = 0;
            var split = data.split("\n");
            console.log(split);
            for(var i=0;i<split.length;i++){
                if(split[i]!=""){
                    count++;
                }
            }
            $("[id=paidflirtingcount]").text(count);
        });
		if (device.platform == "Android")
			setTimeout(navigator.splashscreen.hide, 1000);
    },
    TapFreeFlirting: function(e){
        location.href = "#./views/freeflirting/index.html";
        document.getElementById('cStatus').value="1";
    },
    TapDailyFlirting: function(e){
    	document.getElementById('cStatus').value="1";
        if(window.localStorage.getItem("AppPurchased") == "1"){
            location.href = "#./views/paidflirting/index.html";
        }
        else{
            if(device.platform == "iOS"){
                                          
              function purchaseCallBack(button){
                  if(button == 2) {
                                          window.plugins.spinnerDialog.show();

                                          window.storekit.purchase("subscribe.depression.tips", 1);

                  }
              }
            
              navigator.notification.confirm("UNLOCK ALL Depression Health Tips? Subscribe to Unlock for complete information on Symptoms, Treatment, Causes, Diagnosis, Prevention, Statistics and Facts. UNLOCK and get NEW Gout Depression Tips with every update, stay informed!", purchaseCallBack, null, "No, Yes");
                                          
            }
            else if(device.platform == "Android"){
				function purchaseCallBack(button){
					if(button == 2) {
						inappbilling.getPurchases(//get purchases
							function(result){                        	
								var strResult = "";                            
								if(typeof result === 'object') {
									strResult = JSON.stringify(result);                                   
								} else {
									strResult = result;                                   
								}
											   
								if(strResult.indexOf("subscribe.depression.tips") > -1){
									$(".menu-item.locked").attr("class","menu-item");
									window.localStorage.setItem("AppPurchased", "1");
                    
                    // remove the add if it exists 
                    app.hideAdWhenPurchased();
                    
								}
								else{
									inappbilling.subscribe(
										function(result){
											var strResult = "";
											if(typeof result === 'object') {
												strResult = JSON.stringify(result);
											} else {
												strResult = result;
											}
											console.log(strResult);
											$(".menu-item.locked").attr("class","menu-item");
											window.localStorage.setItem("AppPurchased", "1");
                    
                    // remove the add if it exists 
                    app.hideAdWhenPurchased();

                    
										},
										function(error){
											//alert(error);
										},
										"subscribe.depression.tips"
									);
								}
							},
							function(error){
							 //   console.log(error);
							}
						);
					}					
				}
				navigator.notification.confirm("UNLOCK ALL Depression Health Tips? Subscribe to Unlock for complete information on Symptoms, Treatment, Causes, Diagnosis, Prevention, Statistics and Facts. UNLOCK and get NEW Gout Depression Tips with every update, stay informed!", purchaseCallBack, null, "No, Yes");
            }
        }
    },
    TapFavorite: function(e){
    	document.getElementById('cStatus').value="1";
        location.href = "#./views/favorite/index.html";
    },
                                          
      TapRestore: function(e)
      {
          function restoreCallBack(button){
              if(button == 2) {
                                          
                 window.plugins.spinnerDialog.show("", "Loading...");
                                          
                 window.storekit.restore();
              }
          }
          
          navigator.notification.confirm("Do you want to Restore your Purchase?", restoreCallBack, null, "No, Yes");
                                          
      },
      TapAd: function(e){
      window.open('http://www.happyhealthtoday.com/depression' ,'_system', 'status=1,toolbar=1');
    }
});

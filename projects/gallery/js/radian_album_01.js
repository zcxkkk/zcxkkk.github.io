

function initGallery(){
	  alert("im in");
	  $.getJSON("albumJson.json",function(result){
		  $.each( result, function(index, value) {
		    var albumHtml = "";
		    albumHtml += "<div class=\"album\" data-jgallery-album-title=\"" + value.albumTitle + "\"\>";
		    albumHtml += "<h1>"+ value.h1 + "</h1>";
		    $.each( value.images, function(index, photo) {
		      albumHtml += "<a href=\"" + photo.largeUrl + "\">";
			  albumHtml += "<img src=\"" + photo.thumbUrl + "\" ";
              albumHtml += "alt=\"" + photo.alt + "\" ";
		      albumHtml += "data-jgallery-bg-color=\"" + photo.bgColor + "\" ";
		      albumHtml += "data-jgallery-text-color=\"" + photo.textColor + "\" /></a>";
		  });
		  albumHtml += "</div>";
          $("#gallery").append(albumHtml);
		});
		alert("get end");
	  });
}

$.ajax({
 type: "POST",
 url: "albumJson.json",
 async: false,
 dataType: "json",
 success: function(data){
	 alert("success");
	 var jsonFile = JSON.stringify(data);
    //do something
	 $.each(jsonFile, function(index, value) {
		    var albumHtml = "";
		    albumHtml += "<div class=\"album\" data-jgallery-album-title=\"" + value.albumTitle + "\"\>";
		    albumHtml += "<h1>"+ value.h1 + "</h1>";
		    $.each( value.images, function(index, photo) {
		      albumHtml += "<a href=\"" + photo.largeUrl + "\">";
			  albumHtml += "<img src=\"" + photo.thumbUrl + "\" ";
              albumHtml += "alt=\"" + photo.alt + "\" ";
		      albumHtml += "data-jgallery-bg-color=\"" + photo.bgColor + "\" ";
		      albumHtml += "data-jgallery-text-color=\"" + photo.textColor + "\" /></a>";
		  });
		  albumHtml += "</div>";
          $("#gallery").append(albumHtml);
	});

 },
       
 error: function(XMLHttpRequest, textStatus, errorThrown) {
    alert("请求失败!");
 }
});
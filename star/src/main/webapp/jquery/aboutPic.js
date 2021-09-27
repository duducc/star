var imgDiv; 
var maxwidth;
var maxheight;
var width;
var height;
function loadPic(picPath, imgDiv1,maxwidth1,maxheight1,width1,height1) {
	imgDiv = imgDiv1;
	maxwidth = maxwidth1;
	maxheight = maxheight1;
	width = width1;
	height = height1;
	if (picPath) {
		var filepath = picPath.substring(picPath.lastIndexOf('.') + 1,
				picPath.length)
		if (filepath != "" && filepath.toUpperCase() != "JPG"
				&& filepath.toUpperCase() != "JPEG"
				&& filepath.toUpperCase() != "BMP") {
			alert("必须上传JPG格式或JPEG格式的图片或BMP格式的图片!")
			path = "";
		}
		imgDiv.hide();
		if ($.browser.msie) {
			if ($.browser.version == "6.0") {
				var img = $("<img />");
				imgDiv.replaceWith(img);
				imgDiv = img;

				var image = new Image();
				image.src = 'file:///' + picPath;

				imgDiv.attr('src', image.src);
				autoScaling();
			} else {
				imgDiv.css({
					filter : "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image)"
				});
				imgDiv.get(0).filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").sizingMethod = "image";
				try {
					imgDiv.get(0).filters
							.item('DXImageTransform.Microsoft.AlphaImageLoader').src = picPath;
				} catch (e) {
					alert("无效的图片文件！");
					return;
				}
				setTimeout("autoScaling()", 100);
			}
		} else {
			var img = $("<img />");
			imgDiv.replaceWith(img);
			imgDiv = img;
			imgDiv.attr('src', this.files.item(0).getAsDataURL());
			imgDiv.css({
						"vertical-align" : "middle"
					});
			setTimeout("autoScaling()", 100);
		}
	}
}
function autoScaling() {
	if ($.browser.version == "7.0" || $.browser.version == "8.0")
		imgDiv.get(0).filters
				.item("DXImageTransform.Microsoft.AlphaImageLoader").sizingMethod = "image";
	var img_width = imgDiv.width();
	var img_height = imgDiv.height();
	if (img_width > maxwidth || img_height > maxheight) {
		alert("图片大小不符合要求");
		clearvalue(_this[0]);
		_this.trigger("blur"); // 失去控件焦点

		imgDiv.hide();
		return false;
	}

	if (img_width > 0 && img_height > 0) {
		var rate = (width / img_width < height / img_height)
				? width / img_width
				: height / img_height;
		if (rate <= 1) {
			if ($.browser.version == "7.0" || $.browser.version == "8.0")
				imgDiv.get(0).filters
						.item("DXImageTransform.Microsoft.AlphaImageLoader").sizingMethod = "scale";
			imgDiv.width(img_width * rate);
			imgDiv.height(img_height * rate);
		} else {
			imgDiv.width(img_width);
			imgDiv.height(img_height);
		}
		var left = (width - imgDiv.width()) * 0.5;
		var top = (height - imgDiv.height()) * 0.5;
		imgDiv.css({
					"margin-left" : left,
					"margin-top" : top
				});
		imgDiv.show();
	}

}
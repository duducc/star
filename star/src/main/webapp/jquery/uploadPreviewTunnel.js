(function($) {
	jQuery.fn
			.extend({
				uploadPreview : function(opts) {
					opts = jQuery.extend({
						width : 0,
						height : 0,
						imgDiv : "#imgDiv",
						imgType : [ "gif", "jpeg", "jpg", "bmp", "png" ],
						maxwidth : 0,
						maxheight : 0,
						imgurl : null,
						callback : function() {
							return false;
						}
					}, opts || {});
					var _self = this;
					var _this = $(this);
					var imgDiv = $(opts.imgDiv);

					imgDiv.width(opts.width);
					imgDiv.height(opts.height);

					autoScaling = function() {
						if ($.browser.version == "7.0"
								|| $.browser.version == "8.0")
							imgDiv.get(0).filters
									.item("DXImageTransform.Microsoft.AlphaImageLoader").sizingMethod = "image";
						var img_width = imgDiv.width();
						var img_height = imgDiv.height();
						if (img_width > opts.maxwidth
								|| img_height > opts.maxheight) {
							alert("ͼƬ��С������Ҫ��");
							clearvalue(_this[0]);
							_this.trigger("blur"); // ʧȥ�ؼ�����

							imgDiv.hide();
							return false;
						}

						if (img_width > 0 && img_height > 0) {
							var rate = (opts.width / img_width < opts.height
									/ img_height) ? opts.width / img_width
									: opts.height / img_height;
							if (rate <= 1) {
								if ($.browser.version == "7.0"
										|| $.browser.version == "8.0")
									imgDiv.get(0).filters
											.item("DXImageTransform.Microsoft.AlphaImageLoader").sizingMethod = "scale";
								imgDiv.width(img_width * rate);
								imgDiv.height(img_height * rate);
							} else {
								imgDiv.width(img_width);
								imgDiv.height(img_height);
							}
							var left = (opts.width - imgDiv.width()) * 0.5;
							var top = (opts.height - imgDiv.height()) * 0.5;
							imgDiv.css({
								"margin-left" : left,
								"margin-top" : top
							});
							imgDiv.show();
						}
					}
					_this
							.change(function() {
								alert(this.value);
								if (this.value) {
									if (!RegExp(
											"\.(" + opts.imgType.join("|")
													+ ")$", "i").test(
											this.value.toLowerCase())) {
										alert("ͼƬ���ͱ�����"
												+ opts.imgType.join("��")
												+ "�е�һ��");
										this.value = "";
										return false;
									}
									imgDiv.hide();
									if ($.browser.msie) {
										if ($.browser.version == "6.0") {
											var img = $("<img />");
											imgDiv.replaceWith(img);
											imgDiv = img;

											var image = new Image();
											image.src = 'file:///' + this.value;

											imgDiv.attr('src', image.src);
											autoScaling();
										} else {
											imgDiv
													.css({
														filter : "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image)"
													});
											imgDiv.get(0).filters
													.item("DXImageTransform.Microsoft.AlphaImageLoader").sizingMethod = "image";
											try {
												alert(getPath(_this[0]));
												imgDiv.get(0).filters
														.item('DXImageTransform.Microsoft.AlphaImageLoader').src = getPath(_this[0]);
											} catch (e) {
												alert("��Ч��ͼƬ�ļ���");
												return;
											}
											setTimeout("autoScaling()", 100);

										}
									} else {
										var img = $("<img />");
										imgDiv.replaceWith(img);
										imgDiv = img;
										imgDiv.attr('src', this.files.item(0)
												.getAsDataURL());
										imgDiv.css({
											"vertical-align" : "middle"
										});
										setTimeout("autoScaling()", 100);
									}
								}
							});
				}
			});
})(jQuery);

// ����ϴ��ؼ���ֵ��objΪ�ϴ��ؼ�����
function getPath(obj) {
	if (obj) {
		if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
			obj.select();
			return document.selection.createRange().text;
		} else if (window.navigator.userAgent.indexOf("Firefox") >= 1
				|| navigator.userAgent.indexOf("Mozilla") >= 1) {
			if (obj.files) {
				// return obj.files.item(0).getAsDataURL();
				return window.URL.createObjectURL(obj.files[0]); 
			}
			return obj.value;
		}
		return obj.value;
	}
}

// ����ϴ��ؼ���ֵ��objΪ�ϴ��ؼ�����
function clearvalue(obj) {
	obj.select();
	document.execCommand("delete");
	document.selection.clear();
}

// ͼƬԤ��Ч��--Jacky

$(document).ready(
		function() {
			$('#pic1').change(
					function() {
						var option= $('#option').val();
						var strSrc = this.value;
						img = new Image();
						img.src = getPath(this);
						var pos = strSrc.lastIndexOf('.');
						var lastName = strSrc.substring(pos, strSrc.length);
						if (lastName.toLowerCase() != ".jpg"
								&& lastName.toLowerCase() != ".png"
								&& lastName.toLowerCase() != ".gif"
								&& lastName.toLowerCase() != ".bmp") {
//							alert('��ѡ����ȷ��ʽ��ͼƬ��');
//							$('#btnremove').hide();
//						    $('#btnsave').hide();
							return;
						}else{
//							$('#btnremove').show();
//							$('#btnsave').show();
						}
						if (img.height > 768 || img.width > 1366) {
//							alert('ͼƬ��С�����ݣ�');
//							$('#btnremove').hide();
//						    $('#btnsave').show();
							return;
						}else{
//							$('#btnremove').show();
//							$('#btnsave').show();
						}
						if (img.fileSize / 1024 > 1024) {
//							alert('���ϴ���ͼƬ����1M���ƣ�');
//							$('#btnremove').hide();
//						    $('#btnsave').hide();
							return;
						}else{
//							$('#btnremove').show();
//							$('#btnsave').show();
						}
						$('#imgs0').attr('src', strSrc);
						showPic();
					});
			$('#pic2').change(
					function() {
						var option= $('#option').val();
						var strSrc = this.value;
						img = new Image();
						img.src = strSrc;
						var pos = strSrc.lastIndexOf('.');
						var lastName = strSrc.substring(pos, strSrc.length);
						if (lastName.toLowerCase() != ".jpg"
								&& lastName.toLowerCase() != ".png"
								&& lastName.toLowerCase() != ".gif"
								&& lastName.toLowerCase() != ".bmp") {
							return;
						}else{
						}
						if (img.height > 768 || img.width > 1366) {
							return;
						}else{
						}
						if (img.fileSize / 1024 > 1024) {
							return;
						}else{
						}
						$('#imgs1').attr('src', strSrc);
						showPic();
					});
			$('#pic3').change(
					function() {
						var option= $('#option').val();
						var strSrc = this.value;
						img = new Image();
				//		img.src = getPath(this);
						img.src = strSrc;
						var pos = strSrc.lastIndexOf('.');
						var lastName = strSrc.substring(pos, strSrc.length);
						if (lastName.toLowerCase() != ".jpg"
								&& lastName.toLowerCase() != ".png"
								&& lastName.toLowerCase() != ".gif"
								&& lastName.toLowerCase() != ".bmp") {
							return;
						}else{
						}
						if (img.height > 768 || img.width > 1366) {
							return;
						}else{
						}
						if (img.fileSize / 1024 > 1024) {
							return;
						}else{
						}
						$('#imgs2').attr('src', strSrc);
						showPic();
					});
		});

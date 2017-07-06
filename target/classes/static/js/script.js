$(document).ready(function() {
	var vm = new Vue({
		el : '#page',
		data : {
			list : '',
			totalPage : -1,
			currentPage : 0,
			pageSize : 0,
			isByPid : false,
			pid : 0,
			isBySerach : false,
			param : '',
		},
		computed : {
			isFirstPage : function() {
				return (this.currentPage == 0);
			},
			isLastPage : function() {
				return (this.currentPage == this.totalPage - 1);
			},
			getPrevious : function() {
				return this.currentPage - 1;
			},
			getNext : function() {
				return this.currentPage + 1;
			}
		},
		methods : {
			updatepage : function(e) {
				var self = this;
				var target = e.target.parentNode;
				var Class = target.getAttribute("class");
				var url;
				/*				if (self.isByPid)
									url = "index/IndexBookAction_findByPid?pid=" + self.pid + "&page=" + target.getAttribute("page");
								else if (self.isBySearch)
									url = "index/IndexBookAction_search?=" + self.param + "&page=" + target.getAttribute("page");
								else
									url = "index/IndexBookAction_findAll?page=" + target.getAttribute("page");*/
				if (self.isByPid)
					url = "index/findByPid/" + self.pid + "/page/" + target.getAttribute("page");
				else if (self.isBySearch)
					url = "index/IndexBookAction_search?=" + self.param + "&page=" + target.getAttribute("page");
				else
					url = "index/findAll/page/" + target.getAttribute("page");
				$.ajax({
					type : "POST",
					url : url,
					dataType : "json",
					success : function(json) {
						/*self.list = json.list;
						self.totalPage = json.totalPage;
						self.currentPage = json.currentPage;
						self.pageSize = json.pageSize;*/
						self.list = json.content;
						self.totalPage = json.totalPages;
						self.currentPage = json.number;
						self.pageSize = json.size;
					},
					beforeSend : function(XMLHttpRequest) {
						if (Class == "disabled")
							return false;
					}
				})
			}
		}
	});
	var sidebar = new Vue({
		el : '#sidebar',
		data : {
			pid1 : '',
			pid2 : '',
			pid3 : '',
		},
		methods : {
			findall : function() {
				$.ajax({
					type : "POST",
					url : "index/findAll/page/0",
					dataType : "json",
					success : function(json) {
						vm.list = json.content;
						vm.totalPage = json.totalPages;
						vm.currentPage = json.number;
						vm.pageSize = json.size;
						vm.isByPid = false;
						vm.isBySearch = false;
					},
				})
			},
			findbypid : function(e) {
				var pid = e.target.getAttribute("pid");
				$.ajax({
					type : "POST",
					url : "index/findByPid/" + pid + "/page/0",
					dataType : "json",
					success : function(json) {
						vm.list = json.content;
						vm.totalPage = json.totalPages;
						vm.currentPage = json.number;
						vm.pageSize = json.size;
						vm.isByPid = true;
						vm.pid = pid;
						vm.isBySearch = false;
					/*						vm.totalPage = json.totalPage;
											vm.currentPage = json.currentPage;
											vm.pageSize = json.pageSize;
											vm.isByPid = true;
											vm.pid = pid;
											vm.isBySearch = false;*/
					},
					beforeSend : function() {
						if (e.target.classList.contains("active"))
							return false;
					}
				})
			},
		},
	});
	$("#search").click(function(Event) {
		var val = $("#title").val();
		$.ajax({
			type : "POST",
			url : "index/search/" + val + "/page/0",
			dataType : "json",
			success : function(json) {
				vm.list = json.content;
				vm.totalPage = json.totalPages;
				vm.currentPage = json.number;
				vm.pageSize = json.size;
				vm.isByPid = false;
				vm.isBySearch = true;
				vm.param = $("#title").val();
			},
			beforeSend : function() {
				if (val == "")
					return false;
			}
		});
	})
	$("#leavemessage").click(function(Event) {
		var val = $("#textarea").val();
		$.ajax({
			type : "POST",
			url : "index/message",
			data : val,
			contentType : 'application/json',
			success : function(data) {
				Lobibox.notify(
					'success',
					{
						delay : 3000,
						title : '留言成功',
						sound : false,
						msg : '您的建议将帮助我们做的更好',
					}
				);
			},
			beforeSend : function() {
				if (val == "") {
					Lobibox.notify(
						'info',
						{
							delay : 3000,
							title : '留言失败',
							sound : false,
							msg : '不说点什么吗...您的建议将帮助我们做的更好！',
						}
					);
					return false;
				}
			},
			error : function() {
				Lobibox.notify(
					'error',
					{
						delay : 3000,
						title : '留言失败',
						sound : false,
						msg : '服务器出了点问题...',
					}
				);
			},
		});
	});
});
$(function() {
	$("#menu").metisMenu();
	$(".firstitem").click(function() {
		$(".firstitem").removeClass("active");
		$(this).addClass("active");
	});
/*	$(".list-group").on("click", ".list-group-item", function() {
		$(".list-group>a").removeClass("active");
		$(this).addClass("active");
	});*/
/*$("#login").click(function() {
	var username = $("#username").val();
	var password = $("#password").val();
	$("#loginerror").empty();
	$.ajax({
		type : "POST",
		url : "index/IndexBookAction_login",
		data : {
			username : username,
			password : password
		},
		dataType : "text",
		beforeSend : function() {
			if (username == "" || password == "")
				return false;
		},
		success : function(data) {
			if (data == "success")
				window.location.href = "admin/AdminAction";
			else
				$("#loginerror").html("用户名/密码错误!");
		}
	})
});*/
});
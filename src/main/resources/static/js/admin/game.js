layui.use(['table', 'form', 'jquery', 'layer', 'upload','element'], function() {
	var table = layui.table,
		$ = layui.jquery,
		layer = layui.layer,
		upload = layui.upload,
		element =layui.element,
		form = layui.form;

	var game_tb = table.render({
		elem: '#game_tb',
		url: '/game/searchcode',
		cols: [
			[{
				field: 'gameId',
				title: 'ID',
				width: 110,
				fixed: 'left',
				sort: true
			}, {
				field: 'gameName',
				title: '商品名',
				width: 120
			}, {
				field: 'categoryName',
				title: '分类',
				width: 80,
				templet: function(res) {
					return '<span class="layui-badge-rim">' + res.category.categoryName + '</span>';
				}
			}, {
				field: 'description',
				title: '简介',
				width: 120
			}, {
				field: 'isbn',
				title: 'ISBN',
				width: 120,
				templet: function(res) {
					return '<em>' + res.isbn + '</em>'
				}
			}, {
				field: 'press',
				title: '制造商',
				width: 120
			}, {
				field: 'author',
				title: '产地',
				width: 100
			}, {
				field: 'pubDate',
				title: '生产日期',
				width: 120
			}, {
				field: 'price',
				title: '价格',
				width: 80
			},  {
				field: 'stock',
				title: '库存',
				width: 80
			}, {
				field: 'createTime',
				title: '上架时间',
				width: 120
			}, {
				fixed: 'right',
				title: '操作',
				toolbar: '#barDemo',
				width: 150
			}]
		],
		page: true,
		height: 500
	});




	//监听行工具事件
	table.on('tool(game_tb)', function(obj) {
		var data = obj.data;
		if (obj.event === 'del') {
			layer.confirm('真的删除行么', {
				icon: 3
			}, function(index) {
				$.ajax({
					url: '/game/delete',
					type: 'post',
					data: {gameId:data.gameId},
					dataType: 'json',
					success: function(res) {
						if (res.code != 0) {
							return layer.msg("删除失败：" + res.msg, {
								icon: 2
							});
						}
						return layer.msg("删除成功", {
							icon: 1,
							time: 1300
						}, function() {
							obj.del();
						});
					}
				});
				layer.close(index);
			});
		} else if (obj.event === 'edit') {
			layer.open({
				type: 1,
				title: '编辑商品',
				content: $("#game_form_tmpl").html(),
				area: ['500px'],
				btn: ['更新'],
				yes: function(index1) {
					let new_data=form.val("game-form");
					$.ajax({
						url: '/game/update',
						type: 'post',
						data: new_data,
						dataType: 'json',
						success: function(res) {
							if (res.code != 0) {
								return layer.msg(res.msg, {
									icon: 2
								});
							}
							return layer.msg("更新成功", {
								icon: 1,
								time: 1300
							}, function() {
								obj.update(new_data);
								layer.close(index1);
							});
						}
					});
				},
				success: function() {
					form.render(null, "game-form");
					$("#gameId").attr("disabled", true);
					$.getJSON("/category/searchall", function(res) {
						if (res.code != 0) {
							return;
						}
						$.each(res.data, function(index, item) {
							$("#categoryCode").append('<option value="' + item.categoryCode + '">' + item.categoryName +
								'</option> ');
						});
						//填充表单（编辑状态）
						form.val("game-form", data);
						form.render();
					});
				}
			});
		}
	});


	//搜索
	var game_tb_this;
	form.on('submit(search_btn)', function(data) {
		if (game_tb_this != null) {
			game_tb_this.where = {};
		}
		game_tb.reload({
			url: '/game/search',
			where: data.field,
			page: {
				curr: 1
			},
			done: function() {
				game_tb_this = this;
			}
		});
		return false;
	});

});

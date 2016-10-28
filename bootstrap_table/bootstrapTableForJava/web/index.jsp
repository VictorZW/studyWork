<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <title>Bootstrap Table示例</title>
  <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="resources/bootstrap-table/bootstrap-table.css" rel="stylesheet">


  <script type="text/javascript" src="resources/js/jquery-1.12.2.min.js"></script>
  <script type="text/javascript" src="resources/bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="resources/bootstrap-table/bootstrap-table.js"></script>
  <script type="text/javascript" src="resources/bootstrap-table/bootstrap-table-zh-CN.js"></script>
  <style type="text/css">
    .row-index {
      width: 50px;
      display: inline-block;
    }
  </style>
  <script type="text/javascript">
    function queryParams() {
      return {
        type: 'owner',
        sort: 'updated',
        direction: 'desc',
        per_page: 100,
        page: 1
      };
    }
  </script>
</head>
<body style="margin:20px;">

<div id="toolbar" class="btn-group">
  <button type="button" class="btn btn-default">
    <i class="glyphicon glyphicon-stats" title="生成图表"></i>
  </button>
</div>

<table data-toggle="table"
       data-url="getTableData.action"
       data-query-params="queryParams"
       data-pagination="true"
       data-search="true"
       data-height="500"
       data-show-refresh="true"
       data-show-columns="true"
       data-toolbar="Delete">
  <thead>
  <tr>
    <th data-field="name">Name</th>
    <th data-field="stargazers_count">Stars</th>
    <th data-field="forks_count">Forks</th>
    <th data-field="description">Description</th>
  </tr>
  </thead>
</table>


</body>
</html>
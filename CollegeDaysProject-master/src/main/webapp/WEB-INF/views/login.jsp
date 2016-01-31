<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>CollegeDays</title>
<link rel="shortcut icon" href="/favicon.ico" />
<link href="css/font-awesome.min.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/ui.fancytree.css" rel="stylesheet">
<link href="css/prettify/prettify.css" rel="stylesheet">
<link href="css/octicons/octicons.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">

</head>
<body>

	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">CollegeDays</a>
			</div>
		</div>
	</div>
	<h1>${pageContext.request.contextPath}</h1>
	<div class="container-fluid">
		<form class="form-signin" action='${pageContext.request.contextPath}/login' method='POST'>
			<h2 class="form-signin-heading">CollegeDays</h2>

			<div class="input-group" style="margin-bottom: 5px;">
			  <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
			  <input type="text" name="username" class="form-control" placeholder="Enter Email" required autofocus>
			</div>
			<div class="input-group" style="margin-bottom: 5px;">
			  <span class="input-group-addon"><i class="fa fa-key fa-fw"></i></span>
			  <input type="password" name="password" class="form-control" style="margin-bottom: 0px;" placeholder="Enter Password" required>
			</div>			
			
			<button class="btn btn-primary btn-block" type="submit">Sign in to CollegeDays</button>
		</form>
	</div>

	<script>
	var ctx = "${pageContext.request.contextPath}";
    </script>
</body>
</html>

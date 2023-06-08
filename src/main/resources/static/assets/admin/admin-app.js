var app = angular.module("myApp", ["ngRoute"])
app.config(function($routeProvider) {
    $routeProvider
	.when("/product",{
		templateUrl:"/assets/admin/product/index.html",
		controller:"product-ctrl"
	})
	.when("/authorize",{
		templateUrl:"/assets/admin/authority/index.html",
		controller:"authority-ctrl"
	})
	.when("/authorized",{
		templateUrl:"/assets/admin/authority/unaauthorized.html",
		controller:"authority-ctrl"
	})
	.otherwise({
		template:"<h1 class ='text-center'> ADMIN</h1> "
	})
})
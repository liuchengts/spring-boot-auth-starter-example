# spring-boot-auth-starter
基于springbootweb的权限拦截验证
### 使用前需要的准备
### 使用说明
* 说明：主要针对需要登录或需要访问权限的资源使用
* @Auth 权限注解
* @NoAuthGetSession 不强制校验权限(默认不强制校验）
* @IgnoreLogin 允许不登录(默认允许不登录）

#### 权限注解的使用
* 三个注解可以叠加使用，优先级(由高到低)为 @IgnoreLogin @NoAuthGetSession @Auth
* 三个注解都可以对类或方法级别生效
* 使用示例 参见 com.boot.auth.example.controllers 下的部分示例
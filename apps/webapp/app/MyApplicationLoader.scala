import api.v1.auth.{AuthActionBuilder, AuthController, AuthControllerComponents, AuthResourceHandler, AuthRouter}
import play.api._
import play.api.routing.Router

class MyApplicationLoader extends ApplicationLoader {
  private var components: MyComponents = _

  def load(context: ApplicationLoader.Context): Application = {
    components = new MyComponents(context)
    components.application
  }
}

class MyComponents(context: ApplicationLoader.Context)
  extends BuiltInComponentsFromContext(context)
    with play.filters.HttpFiltersComponents
    with _root_.controllers.AssetsComponents {

  lazy val homeController = new _root_.controllers.HomeController(controllerComponents)

  lazy val authActionBuilder = new AuthActionBuilder(messagesApi, playBodyParsers)
  lazy val authResourceHandler = new AuthResourceHandler

  lazy val authControllerComponents: AuthControllerComponents = AuthControllerComponents(authActionBuilder, authResourceHandler,
    defaultActionBuilder, playBodyParsers, messagesApi, langs, fileMimeTypes, executionContext)

  lazy val authController = new AuthController(authControllerComponents)
  lazy val authRouter = new AuthRouter(authController)

  lazy val router: Router = new _root_.router.Routes(httpErrorHandler, homeController, authRouter, assets)
}

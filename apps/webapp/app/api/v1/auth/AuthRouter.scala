package api.v1.auth

import play.api.routing.SimpleRouter
import play.api.routing.Router.Routes
import play.api.routing.sird._

class AuthRouter (controller: AuthController) extends SimpleRouter {

  val prefix = "/v1/auth"

  override def routes: Routes = {
    case GET(p"/") =>
      controller.index
  }

}

package api.v1.auth

import play.api.Logger
import play.api.libs.json.{Format, Json}
import play.api.mvc._

import scala.concurrent.ExecutionContext

case class AuthenticationResponse(id: Int, value: String)
object AuthenticationResponse {
  implicit val format: Format[AuthenticationResponse] = Json.format
}

class AuthController (cc: AuthControllerComponents)(implicit ec: ExecutionContext)
  extends AuthBaseController(cc)
{
  private val logger = Logger(getClass)

  def index: Action[AnyContent] = AuthAction { implicit request =>
    logger.trace("index: ")
    Ok(Json.toJson(AuthenticationResponse(1, "value")))
  }

}

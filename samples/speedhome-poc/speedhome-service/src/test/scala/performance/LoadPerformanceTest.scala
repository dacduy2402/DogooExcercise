package performance

import io.gatling.core.Predef.{Simulation, _}
import io.gatling.http.Predef._
import io.gatling.http.protocol.HttpProtocolBuilder


class LoadPerformanceTest extends Simulation{

  var serviceBaseUrl: String = "http://localhost:8080/speedhome/backend/v1"

  val empIdFeeder = csv("./data/empId.csv").shuffle.circular

  val httpConf : HttpProtocolBuilder = http
    .baseUrl(serviceBaseUrl)
    .contentTypeHeader("application/json")

  object Common {
    val get = exec(http("get employee")
      .get("/employees")
      .header("Request-Context","context")
      .check(status.is(200)))
      .pause(5)

    val create = exec(http("create employee")
      .post("/employees")
      .header("Request-Context","context")
      .body(ElFileBody("./bodies/empCreateBody.json"))
      .check(
        jsonPath("$").saveAs("RESPONSE")
      )
      .check(status.is(200)))
      .pause(5)

    val edit = exec(http("get employee")
      .get("/employees/${empId}")
      .header("Request-Context","context")
      .check(status.is(200)))
      .pause(5)
      .exec(http("edit get employee")
        .put("/employees/${empId}")
        .header("Request-Context","context")
        .body(ElFileBody("./bodies/empUpdateBody.json"))
        .check(status.is(200))
      ).pause(5)
      .exec(http("get updated employee")
        .get("/employees/${empId}")
        .header("Request-Context","context")
        .check(status.is(200))
      )
  }

  val employeeScenario = scenario("Domain Service").feed(empIdFeeder).exec(Common.get, Common.create, Common.edit)

  setUp(
    employeeScenario.inject(
      nothingFor(20 ),
      constantUsersPerSec(5) during(1)
    ).protocols(httpConf)
  )
}

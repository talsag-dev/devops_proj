
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class BasicSimulation extends Simulation {

  private val httpProtocol = http
    .baseUrl("http://localhost:3500")
    .inferHtmlResources(AllowList(), DenyList())
  
  private val headers_0 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8,he;q=0.7",
  		"Cache-Control" -> "max-age=0",
  		"If-Modified-Since" -> "Thu, 19 May 2022 10:57:14 GMT",
  		"If-None-Match" -> """W/"301-1652957834000"""",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "none",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"User-Agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.64 Safari/537.36",
  		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="101", "Google Chrome";v="101""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS"
  )
  
  private val headers_2 = Map(
  		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9",
  		"Accept-Encoding" -> "gzip, deflate, br",
  		"Accept-Language" -> "en-GB,en-US;q=0.9,en;q=0.8,he;q=0.7",
  		"Sec-Fetch-Dest" -> "document",
  		"Sec-Fetch-Mode" -> "navigate",
  		"Sec-Fetch-Site" -> "same-origin",
  		"Sec-Fetch-User" -> "?1",
  		"Upgrade-Insecure-Requests" -> "1",
  		"User-Agent" -> "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.64 Safari/537.36",
  		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="101", "Google Chrome";v="101""",
  		"sec-ch-ua-mobile" -> "?0",
  		"sec-ch-ua-platform" -> "macOS"
  )


  private val scn = scenario("BasicSimulation")
    .exec(
      http("request_0")
        .get("/devops_proj/")
        .headers(headers_0)
        .resources(
          http("request_1")
            .get("/favicon.ico")
        )
    )
    .pause(25)
    .exec(
      http("request_2")
        .get("/devops_proj/welcome.jsp?uname=3&number=2")
        .headers(headers_2)
    )

	setUp(scn.inject(atOnceUsers(40))).protocols(httpProtocol)
}

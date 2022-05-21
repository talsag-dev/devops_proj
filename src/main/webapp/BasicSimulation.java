
import java.time.Duration;
import java.util.*;

import io.gatling.javaapi.core.*;
import io.gatling.javaapi.http.*;
import io.gatling.javaapi.jdbc.*;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.*;
import static io.gatling.javaapi.jdbc.JdbcDsl.*;

public class BasicSimulation extends Simulation {

  {
    HttpProtocolBuilder httpProtocol = http
      .baseUrl("http://localhost:3500")
      .inferHtmlResources(AllowList(), DenyList())
    ;
    
    Map<CharSequence, String> headers_0 = new HashMap<>();
    headers_0.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
    headers_0.put("Accept-Encoding", "gzip, deflate, br");
    headers_0.put("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8,he;q=0.7");
    headers_0.put("Cache-Control", "max-age=0");
    headers_0.put("If-Modified-Since", "Thu, 19 May 2022 10:57:14 GMT");
    headers_0.put("If-None-Match", "W/\"301-1652957834000\"");
    headers_0.put("Sec-Fetch-Dest", "document");
    headers_0.put("Sec-Fetch-Mode", "navigate");
    headers_0.put("Sec-Fetch-Site", "none");
    headers_0.put("Sec-Fetch-User", "?1");
    headers_0.put("Upgrade-Insecure-Requests", "1");
    headers_0.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.64 Safari/537.36");
    headers_0.put("sec-ch-ua", " Not A;Brand\";v=\"99\", \"Chromium\";v=\"101\", \"Google Chrome\";v=\"101");
    headers_0.put("sec-ch-ua-mobile", "?0");
    headers_0.put("sec-ch-ua-platform", "macOS");
    
    Map<CharSequence, String> headers_2 = new HashMap<>();
    headers_2.put("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9");
    headers_2.put("Accept-Encoding", "gzip, deflate, br");
    headers_2.put("Accept-Language", "en-GB,en-US;q=0.9,en;q=0.8,he;q=0.7");
    headers_2.put("Sec-Fetch-Dest", "document");
    headers_2.put("Sec-Fetch-Mode", "navigate");
    headers_2.put("Sec-Fetch-Site", "same-origin");
    headers_2.put("Sec-Fetch-User", "?1");
    headers_2.put("Upgrade-Insecure-Requests", "1");
    headers_2.put("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.64 Safari/537.36");
    headers_2.put("sec-ch-ua", " Not A;Brand\";v=\"99\", \"Chromium\";v=\"101\", \"Google Chrome\";v=\"101");
    headers_2.put("sec-ch-ua-mobile", "?0");
    headers_2.put("sec-ch-ua-platform", "macOS");


    ScenarioBuilder scn = scenario("BasicSimulation")
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
      );

	  setUp(scn.injectOpen(atOnceUsers(1))).protocols(httpProtocol);
  }
}

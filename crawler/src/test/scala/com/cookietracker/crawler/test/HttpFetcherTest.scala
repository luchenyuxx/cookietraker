package com.cookietracker.crawler.test

import java.net.URL

import akka.pattern.ask
import akka.util.Timeout
import com.cookietracker.crawler.{Fetch, FetchResult, HttpFetcher}

import scala.concurrent.Await
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

class HttpFetcherTest extends AkkaTest {
  "A HttpFetcher" must {
    "successfully fetch google.com" in {
      implicit val timeout = Timeout(3 seconds)
      val httpFetcher = system.actorOf(HttpFetcher.props)
      val url = new URL("http://www.google.com")
      val r = httpFetcher ? Fetch(url)
      val f = r.mapTo[FetchResult].flatMap(_.response)
      Await.result(f, 3 seconds)
      f onFailure {
        case _ => assert(false)
      }
    }
  }
}
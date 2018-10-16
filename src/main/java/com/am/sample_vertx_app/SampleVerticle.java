package com.am.sample_vertx_app;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class SampleVerticle extends AbstractVerticle {
	
	@Override
	public void start(Future<Void> fut) throws Exception {
	
		vertx.createHttpServer()
			.requestHandler(r -> {
				r.response().end("Hello");
				
			})
			.listen(8080, result ->  {
				if (result.succeeded()) {
					fut.complete();
				} else {
	            fut.fail(result.cause());
	          }});
	}

}

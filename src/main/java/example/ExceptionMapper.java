package example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Error;
import io.micronaut.http.hateos.JsonError;
import io.micronaut.http.hateos.Link;

@Controller
public class ExceptionMapper {

    @Error(global = true)
    public HttpResponse<JsonError> error(HttpRequest request, Throwable e) {
        JsonError error = new JsonError("Bad Things Happened: " + e.getMessage())
                .link(Link.SELF, Link.of(request.getUri()));

        return HttpResponse.<JsonError>serverError().body(error);
    }


}

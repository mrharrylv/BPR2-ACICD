package DK.HAPK.ACICD.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-02-29T14:22:28.293993+01:00[Europe/Copenhagen]")

@Controller
@RequestMapping("${openapi.invoice.base-path:}")
public class InvoiceApiController implements InvoiceApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public InvoiceApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}

package DK.HAPK.ACICD.Distribution.API;

import DK.HAPK.ACICD.api.InvoiceApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.HeaderParam;

@RestController
@RequestMapping("/api/v1")
public class InvoiceImpl implements InvoiceApi {
    private final static Logger LOGGER = LogManager.getLogger(InvoiceImpl.class);

    @Override
    public ResponseEntity getInvoice(@HeaderParam("Auth") String auth, @PathVariable("CVR") String cvr) {
        LOGGER.info("Distribution Service was called, looking for company info with CVR: <" + cvr + ">");

        // security check

        // retrieve data

        // return data

        return ResponseEntity.ok().build();
    }
}

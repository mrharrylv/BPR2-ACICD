package DK.HAPK.ACICD.Distribution.API;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import javax.ws.rs.HeaderParam;

public class InvoiceImpl {
    private final static Logger LOGGER = LogManager.getLogger(InvoiceImpl.class);

    public ResponseEntity getInvoice(@HeaderParam("Auth") String auth, @PathVariable("CVR") String cvr) {

        return ResponseEntity.badRequest().build();
    }

}

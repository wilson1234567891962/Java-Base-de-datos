package com.billing.utilities;

import com.billing.cache.EntityCache;
import com.billing.model.BillingDTO;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class Files {

    static Logger logger = Logger.getLogger(Files.class);

    public List<BillingDTO> getObjetBilling() {
        List<BillingDTO> billingDTO = new ArrayList<>();
        EntityCache cache = EntityCache.getEntidadCache();
        try (BufferedReader br = new BufferedReader(new FileReader(cache.getPathFile()))) {
            String register;
            while ((register = br.readLine()) != null) {
                String[] tmp = register.split(cache.getSeparator());
                if (tmp != null && tmp.length >= 2) {
                    BillingDTO mappingBilling = new BillingDTO();
                    mappingBilling.setIdTransaction(Format.convertNumber(tmp[0]));
                    mappingBilling.setIdClient(Format.convertNumber(tmp[1]));
                    mappingBilling.setDateTransaction(Format.convertDate(tmp[2], cache.getFormatDate()));
                    mappingBilling.setValueTransaction(tmp[3]);
                    mappingBilling.setRode(Format.convertNumber(tmp[4]));
                    billingDTO.add(mappingBilling);
                } else {
                    logger.warn("No se carga los datos para esta linea " + register);
                }
            }
        } catch (IOException | ParseException e) {
            logger.error("Se han presentado problemas con el archivo de cargue, por favor revise el error presentado y vuelva intentar", e);
        }
        return billingDTO;
    }
}

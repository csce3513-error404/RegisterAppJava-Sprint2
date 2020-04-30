package edu.uark.registerapp.controllers;

import edu.uark.registerapp.commands.transactions.TransactionQuery;
import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.entities.ActiveUserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import edu.uark.registerapp.models.api.Transaction;
import edu.uark.registerapp.models.api.TransactionEntry;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionRouteController extends BaseRouteController{
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createTransaction(@RequestParam final Map<String, String> queryParameters,final HttpServletRequest request){
        final Optional<ActiveUserEntity> activeUserEntity =
                this.getCurrentUser(request);
        if (!activeUserEntity.isPresent()) {
            return buildInvalidSessionResponse();
        }

        ModelAndView modelAndView =
                this.setErrorMessageFromQueryString(
                        new ModelAndView(ViewNames.TRANSACTION.getViewName()),
                        queryParameters);

        modelAndView.addObject(
                ViewModelNames.IS_ELEVATED_USER.getValue(),
                this.isElevatedUser(activeUserEntity.get()));

        // TODO: Query the transaction? i don't know what y'all intend to do.

        modelAndView.addObject(
            "TransactionId",
            (queryParameters.containsKey("TransactionId")
                ? queryParameters.get("TransactionId")
                : ""));
        modelAndView.addObject(
            "transactionProducts",
            new TransactionEntry[0]); // TODO: Your view is expecting this entry, you probably want to put real data in here.

        return modelAndView.addAllObjects(queryParameters);
    }

    @Autowired
    private TransactionQuery transactionQuery;
}

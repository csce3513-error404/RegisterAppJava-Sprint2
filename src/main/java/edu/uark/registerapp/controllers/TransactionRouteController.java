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
import javax.servlet.http.HttpServletRequest;
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
        request.setAttribute("TransactionId","");
        if((queryParameters.get("TransactionId" != null)))
        {
            request.setAttribute("TransactionId",queryParameters.get("TransactionId"));
            modelAndView.addObject(ViewNames.TRANSACTION.getViewName(), this.transactionQuery.set_T_ID(UUID.fromString(queryParameters.get("TransactionId"))).execute);
        }
    

        return modelAndView.addAllObjects(queryParameters);
    }

    @Autowired
    private TransactionQuery transactionQuery;
}

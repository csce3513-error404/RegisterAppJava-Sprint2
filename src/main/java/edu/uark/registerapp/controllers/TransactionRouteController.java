package edu.uark.registerapp.controllers;

import edu.uark.registerapp.controllers.enums.ViewModelNames;
import edu.uark.registerapp.controllers.enums.ViewNames;
import edu.uark.registerapp.models.entities.ActiveUserEntity;

import java.util.Optional;

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

        modelAndView.addObject(
                this.Transaction
        );

        return modelAndView;
    }

    @Autowired
    private TransactionQuery transactionQuery;
}

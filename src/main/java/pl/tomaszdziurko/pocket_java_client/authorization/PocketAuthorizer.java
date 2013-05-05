package pl.tomaszdziurko.pocket_java_client.authorization;

import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import org.apache.commons.lang3.StringUtils;
import pl.tomaszdziurko.pocket_java_client.communication.RawJsonResponse;
import pl.tomaszdziurko.pocket_java_client.communication.RequestSender;

public class PocketAuthorizer {

    private Gson gson;
    private RequestSender requestSender;

    public PocketAuthorizer() {
        gson = new Gson();
        requestSender = new RequestSender();
    }

    public TokenRequestResponse getRequestToken(String consumerKey, String redirectUri, String state) {
        TokenRequestObject requestObject = new TokenRequestObject(consumerKey, redirectUri, state);
        RawJsonResponse responseWithStatus = requestSender.sendRequest(requestObject, "https://getpocket.com/v3/oauth/request");

        if (responseWithStatus.statusIsOk()) {
            return gson.fromJson(responseWithStatus.getResponse().get(), TokenRequestResponse.class);
        } else {
            return new TokenRequestResponse(responseWithStatus.getStatus());
        }
    }

    public String getAuthorizationUrlFor(String requestToken, String redirectBackUrl) {
        Preconditions.checkArgument(StringUtils.isNotBlank(requestToken), "Request Token must be provided");
        Preconditions.checkArgument(StringUtils.isNotBlank(redirectBackUrl), "Redirect Back Url must be provided");

        return "https://getpocket.com/auth/authorize?request_token=" + requestToken + "&redirect_uri=" + redirectBackUrl;
    }


}

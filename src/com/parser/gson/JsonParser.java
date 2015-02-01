/**
 * 
 */
package com.parser.gson;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.parser.constant.JsonReqConstants;
import com.parser.model.UserInfo;
import com.parser.model.UserInfoExtra;

/**
 * @author pushpendra
 * 
 */
public class JsonParser {
	/**
	 * This method parse the Json request by using google's gson library
	 * @param jsonObject
	 * @return UserInfo Object
	 */
	public UserInfo parseJson(JsonObject jsonObject) {
		UserInfo userInfo = null;
		if (jsonObject.has(JsonReqConstants.USER_INFO)) {
			JsonObject userNode = jsonObject.get(JsonReqConstants.USER_INFO)
					.getAsJsonObject();
			userInfo = new UserInfo();

			if (userNode.has(JsonReqConstants.NAME)) {
				String name = userNode.get(JsonReqConstants.NAME).toString();
				userInfo.setName(name);
			}
			if (userNode.has(JsonReqConstants.LOCATION)) {
				String location = userNode.get(JsonReqConstants.LOCATION)
						.toString();
				userInfo.setLocation(location);
			}
			if (userNode.has(JsonReqConstants.PHONE)) {
				long phone = userNode.get(JsonReqConstants.PHONE).getAsLong();
				userInfo.setPhone(phone);
			}

			if (userNode.has(JsonReqConstants.HOBBIES)) {
				List<String> hobbiesList = new ArrayList();
				JsonArray hobbiesArray = userNode
						.getAsJsonArray(JsonReqConstants.HOBBIES);
				for (int i = 0; i < hobbiesArray.size(); i++) {
					String element = hobbiesArray.get(i).toString();
					hobbiesList.add(element);
				}
				userInfo.setHobbies(hobbiesList);
			}
			if (userNode.has(JsonReqConstants.OTHER_DETAILS)) {
				JsonArray otherDetailsArray = userNode
						.getAsJsonArray(JsonReqConstants.OTHER_DETAILS);
				List<UserInfoExtra> userInfoExtraList = new ArrayList();
				UserInfoExtra userInfoExtra;
				for (int i = 0; i < otherDetailsArray.size(); i++) {
					userInfoExtra = new UserInfoExtra();
					JsonObject json = otherDetailsArray.get(i)
							.getAsJsonObject();
					if (json.has(JsonReqConstants.NICK_NAME)) {
						String nickName = json.get(JsonReqConstants.NICK_NAME)
								.toString();
						userInfoExtra.setNickName(nickName);
					}
					if (json.has(JsonReqConstants.AREA)) {
						String area = json.get(JsonReqConstants.AREA)
								.toString();
						userInfoExtra.setArea(area);
					}
					userInfoExtraList.add(userInfoExtra);
				}
				userInfo.setUserInfoExtra(userInfoExtraList);
			}
		}
		return userInfo;

	}
}

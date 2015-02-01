package com.parser.JSON;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.parser.constant.JsonReqConstants;
import com.parser.model.UserInfo;
import com.parser.model.UserInfoExtra;

public class JSONParser {
	/**
	 * This method parse the Json request by using org.json library
	 * @param jsonObject
	 * @return UserInfo Object
	 * @throws JSONException
	 */
	public UserInfo parseJson(JSONObject jsonObject) throws JSONException {
		UserInfo userInfo = null;
		if (jsonObject.has(JsonReqConstants.USER_INFO)) {
			JSONObject userNode = (JSONObject) jsonObject
					.get(JsonReqConstants.USER_INFO);
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
				long phone = (Long) userNode.get(JsonReqConstants.PHONE);
				userInfo.setPhone(phone);
			}
			if (userNode.has(JsonReqConstants.HOBBIES)) {
				List<String> hobbiesList = new ArrayList();
				JSONArray hobbiesArray = (JSONArray) userNode
						.get(JsonReqConstants.HOBBIES);
				for (int i = 0; i < hobbiesArray.length(); i++) {
					String element = hobbiesArray.get(i).toString();
					hobbiesList.add(element);
				}
				userInfo.setHobbies(hobbiesList);
			}
			if (userNode.has(JsonReqConstants.OTHER_DETAILS)) {
				JSONArray otherDetailsArray = (JSONArray) userNode
						.get(JsonReqConstants.OTHER_DETAILS);
				List<UserInfoExtra> userInfoExtraList=new ArrayList();
				UserInfoExtra userInfoExtra;
				for (int i = 0; i < otherDetailsArray.length(); i++) {
					userInfoExtra=new UserInfoExtra();
					JSONObject json = (JSONObject) otherDetailsArray.get(i);
					if (json.has(JsonReqConstants.NICK_NAME)) {
						String nickName = json.get(JsonReqConstants.NICK_NAME)
								.toString();
						userInfoExtra.setNickName(nickName);
					}
					if(json.has(JsonReqConstants.AREA)){
						String area = json.get(JsonReqConstants.AREA).toString();
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

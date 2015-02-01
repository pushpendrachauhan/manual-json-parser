/**
 * 
 */
package com.parser.jackson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.codehaus.jackson.JsonNode;

import com.parser.constant.JsonReqConstants;
import com.parser.model.UserInfo;
import com.parser.model.UserInfoExtra;

/**
 * @author pushpendra
 * 
 */
public class JsonParser {
	/**
	 * This method parse the Json request by using jackson library
	 * @param jsonNode
	 * @return UserInfo Object
	 */
	public UserInfo parseJson(JsonNode jsonNode) {
		UserInfo userInfo = null;
		if (jsonNode.has(JsonReqConstants.USER_INFO)) {
			
			JsonNode userNode = jsonNode.get(JsonReqConstants.USER_INFO);
			userInfo = new UserInfo();

			if (userNode.has(JsonReqConstants.NAME)) {
				String name = userNode.get(JsonReqConstants.NAME).getValueAsText();
				userInfo.setName(name);
			}
			if (userNode.has(JsonReqConstants.LOCATION)) {
				String location = userNode.get(JsonReqConstants.LOCATION).getValueAsText();
				userInfo.setLocation(location);
			}
			if (userNode.has(JsonReqConstants.PHONE)) {
				long phone = userNode.get(JsonReqConstants.PHONE).getLongValue();
				userInfo.setPhone(phone);
			}
			if (userNode.has(JsonReqConstants.HOBBIES)) {
				List<String> hobbiesList=new ArrayList();
				JsonNode hobbiesNode = userNode.get(JsonReqConstants.HOBBIES);
				Iterator<JsonNode> iterator = hobbiesNode.iterator();
				while( iterator.hasNext()){
					JsonNode next = iterator.next();
					hobbiesList.add(next.getTextValue());
					
				}
				userInfo.setHobbies(hobbiesList);
			}
			if(userNode.has(JsonReqConstants.OTHER_DETAILS)){
				JsonNode otherDetailsNode = userNode.get(JsonReqConstants.OTHER_DETAILS);
				Iterator<JsonNode> iterator = otherDetailsNode.iterator();
				List<UserInfoExtra> userInfoExtraList=new ArrayList();
				UserInfoExtra userInfoExtra;
				while(iterator.hasNext()){
					userInfoExtra=new UserInfoExtra();
					JsonNode next = iterator.next();
					if(next.has(JsonReqConstants.NICK_NAME)){
						String nickName = next.get(JsonReqConstants.NICK_NAME).getValueAsText();
						userInfoExtra.setNickName(nickName);
					}
					if(next.has(JsonReqConstants.AREA)){
						String area = next.get(JsonReqConstants.AREA).getValueAsText();
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

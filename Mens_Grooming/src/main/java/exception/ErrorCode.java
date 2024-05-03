package exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

	
	
		NO_FOUND_ENTITY("존재하지 않는 엔티티입니다."),
		DUPLICATED_ENTITY("이미 존재하는 엔티티입니다."),
		INVALID_REQUEST("요청한 값이 올바르지 않습니다."),
		NOT_FOUND_USER("존재하지 않는 사용자입니다."),
		INTERNAUL_SERVER_ERROR("일시적인 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
		NO_FOUND_ENTITY_COLUM("존재하지 않는 엔티티의 칼럽값입니다.");

		// RequiredArgsConstructor가 먹히지 않기에 생성자 생성
		ErrorCode(String string) {
			this.errorMsg = "";
			// TODO Auto-generated constructor stub
		}

		private final String errorMsg;
}

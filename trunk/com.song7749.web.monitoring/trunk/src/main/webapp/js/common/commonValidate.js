/**
 * 주민등록번호 오류 체크 함수
 *
 * @param string 주민등록번호 13자리
 * or
 * @param string 주민등록번호 앞 6자리
 * @param string 주민등록번호 뒤 7자리
 *
 * @return boolean 오류 여부(true: 오류 없음)
 */
function checkJuminNo(sJuminNo1, sJuminNo2)
{
	var sJuminNo = sJuminNo1 + (sJuminNo2 ? sJuminNo2 : '');
	if (sJuminNo.length != 13) {
		return false;
	}

	switch (sJuminNo.substr(6, 1)) {
	case '1': // 1900년대 남자
	case '2': // 1900년대 여자
	case '3': // 2000년대 남자
	case '4': // 2000년대 여자
		var sWeightCode	= '234567892345';
		var nSum		= 0;
		for (var i = 0; i < 12; i++) {
			nSum += parseInt(sJuminNo.substr(i, 1)) * parseInt(sWeightCode.substr(i, 1));
		}

		var nCheckBit = parseInt(sJuminNo.substr(i, 1));
		if (nCheckBit != ((11 - (nSum % 11)) % 10)) {
			return false;
		}
		break;

	case '5': // 1900년대 외국인 남자
	case '6': // 1900년대 외국인 여자
	case '7': // 2000년대 외국인 남자
	case '8': // 2000년대 외국인 여자
		var sWeightCode	= '234567892345';
		var nSum		= 0;
		for (var i = 0; i < 12; i++) {
			nSum += parseInt(sJuminNo.substr(i, 1)) * parseInt(sWeightCode.substr(i, 1));
		}

		var nCheckBit = parseInt(sJuminNo.substr(i, 1));
		if (nCheckBit != ((((11 - (nSum % 11)) % 10) + 2) % 10)) {
			return false;
		}
		break;

	default:
		return false;
	}

	return true;
}

/**
 * 사업자등록번호 오류 체크 함수
 *
 * @param string 사업자등록번호 10자리
 * or
 * @param string 사업자등록번호 앞 3자리
 * @param string 사업자등록번호 중간 2자리
 * @param string 사업자등록번호 뒤 5자리
 *
 * @return boolean 오류 여부(true: 오류 없음)
 */
function checkSaeopjaNo(sSaeopjaNo1, sSaeopjaNo2, sSaeopjaNo3)
{
	var sSaeopjaNo = sSaeopjaNo1 + (sSaeopjaNo2 ? sSaeopjaNo2 : '') + (sSaeopjaNo3 ? sSaeopjaNo3 : '');
	if (sSaeopjaNo.length != 10) {
		return false;
	}

	var sWeightCode	= '137137135';
	var nSum		= 0;
	for (var i = 0; i < 9; i ++) {
		nSum += parseInt(sSaeopjaNo.substr(i, 1)) * parseInt(sWeightCode.substr(i, 1));
	}
	nSum += parseInt(parseInt(sSaeopjaNo.substr(i - 1, 1)) * 5 / 10);

	var nCheckBit = parseInt(sSaeopjaNo.substr(i, 1));
	if (nCheckBit != ((10 - (nSum % 10)) % 10)) {
		return false;
	}

	return true;
}

/**
 * 한글 체크 함수
 *
 * @param string 문자열
 *
 * @param boolean 한글 여부(true: 한글)
 */
function checkHangul(sStr)
{
	var bResult = true;
	for (var i = 0; i < sStr.length; i++) {
		var nChar = sStr.charCodeAt(i);
		if ((nChar >= 0xAC00) && (nChar <= 0xD7AF)) {
			continue;
		} else {
			bResult = false;
			break;
		}
	}

	return bResult;
}

/**
 * 주민등록번호 나이(만) 계산 함수
 *
 * @param string 주민등록번호 13자리
 * or
 * @param string 주민등록번호 앞 6자리
 * @param string 주민등록번호 뒤 7자리
 *
 * @return integer 나이(만) or boolean false
 */
function calJuminNo2Age(sJuminNo1, sJuminNo2)
{
	var sJuminNo = sJuminNo1 + (sJuminNo2 ? sJuminNo2 : '');
	if (sJuminNo.length != 13) {
		return false;
	}

	var oNow	= new Date();
	var nYear	= oNow.getFullYear();
	var nMonth	= oNow.getMonth() + 1;
	var nDay	= oNow.getDate();

	var nType		= parseInt(sJuminNo.substr(6, 1), 10);
	var nBirthYear	= parseInt(sJuminNo.substr(0, 2), 10);
	var nBirthMonth	= parseInt(sJuminNo.substr(2, 2), 10);
	var nBirthDay	= parseInt(sJuminNo.substr(4, 2), 10);

	nBirthYear = 1900 + (1 - (Math.ceil(nType / 2) % 2)) * 100 + nBirthYear;

	var nAge = nYear - nBirthYear;
	if (nMonth < nBirthMonth) {
		nAge--;
	} else if ((nMonth == nBirthMonth) && (nDay < nBirthDay)) {
		nAge--;
	}

	return nAge;
}

var numberFormat = function (nPrice){
	var sPrice = '' + nPrice;
    var format = /[^0-9]/g;
    var checkFormat = /(-?[0-9]+)([0-9]{3})/;
    sPrice = sPrice.replace(format,'');              
     while (checkFormat.test(sPrice)) { 
		sPrice = sPrice.replace(checkFormat, "$1,$2"); 
	}
	return sPrice;
};
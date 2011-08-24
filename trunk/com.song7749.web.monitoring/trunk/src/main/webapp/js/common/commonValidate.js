/**
 * �ֹε�Ϲ�ȣ ���� üũ �Լ�
 *
 * @param string �ֹε�Ϲ�ȣ 13�ڸ�
 * or
 * @param string �ֹε�Ϲ�ȣ �� 6�ڸ�
 * @param string �ֹε�Ϲ�ȣ �� 7�ڸ�
 *
 * @return boolean ���� ����(true: ���� ����)
 */
function checkJuminNo(sJuminNo1, sJuminNo2)
{
	var sJuminNo = sJuminNo1 + (sJuminNo2 ? sJuminNo2 : '');
	if (sJuminNo.length != 13) {
		return false;
	}

	switch (sJuminNo.substr(6, 1)) {
	case '1': // 1900��� ����
	case '2': // 1900��� ����
	case '3': // 2000��� ����
	case '4': // 2000��� ����
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

	case '5': // 1900��� �ܱ��� ����
	case '6': // 1900��� �ܱ��� ����
	case '7': // 2000��� �ܱ��� ����
	case '8': // 2000��� �ܱ��� ����
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
 * ����ڵ�Ϲ�ȣ ���� üũ �Լ�
 *
 * @param string ����ڵ�Ϲ�ȣ 10�ڸ�
 * or
 * @param string ����ڵ�Ϲ�ȣ �� 3�ڸ�
 * @param string ����ڵ�Ϲ�ȣ �߰� 2�ڸ�
 * @param string ����ڵ�Ϲ�ȣ �� 5�ڸ�
 *
 * @return boolean ���� ����(true: ���� ����)
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
 * �ѱ� üũ �Լ�
 *
 * @param string ���ڿ�
 *
 * @param boolean �ѱ� ����(true: �ѱ�)
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
 * �ֹε�Ϲ�ȣ ����(��) ��� �Լ�
 *
 * @param string �ֹε�Ϲ�ȣ 13�ڸ�
 * or
 * @param string �ֹε�Ϲ�ȣ �� 6�ڸ�
 * @param string �ֹε�Ϲ�ȣ �� 7�ڸ�
 *
 * @return integer ����(��) or boolean false
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
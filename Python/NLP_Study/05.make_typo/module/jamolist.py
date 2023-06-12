

CHO = (
    u'ㄱ', u'ㄲ', u'ㄴ', u'ㄷ', u'ㄸ', u'ㄹ', u'ㅁ', u'ㅂ', u'ㅃ', u'ㅅ',
    u'ㅆ', u'ㅇ', u'ㅈ', u'ㅉ', u'ㅊ', u'ㅋ', u'ㅌ', u'ㅍ', u'ㅎ'
)

JUNG = (
    u'ㅏ', u'ㅐ', u'ㅑ', u'ㅒ', u'ㅓ', u'ㅔ', u'ㅕ', u'ㅖ', u'ㅗ', u'ㅘ',
    u'ㅙ', u'ㅚ', u'ㅛ', u'ㅜ', u'ㅝ', u'ㅞ', u'ㅟ', u'ㅠ', u'ㅡ', u'ㅢ', u'ㅣ'
)

JONG = (
    u'', u'ㄱ', u'ㄲ', u'ㄳ', u'ㄴ', u'ㄵ', u'ㄶ', u'ㄷ', u'ㄹ', u'ㄺ',
    u'ㄻ', u'ㄼ', u'ㄽ', u'ㄾ', u'ㄿ', u'ㅀ', u'ㅁ', u'ㅂ', u'ㅄ', u'ㅅ',
    u'ㅆ', u'ㅇ', u'ㅈ', u'ㅊ', u'ㅋ', u'ㅌ', u'ㅍ', u'ㅎ'
)

FIRST_HANGUL_UNICODE = 0xAC00  # '가'
LAST_HANGUL_UNICODE = 0xD7A3  # '힣'
DEFAULT_COMPOSE_CODE = u'ᴥ'

# EOJEOL_TYPO = {'완전':'오나전', '뭘': '무러', '했는데':'햇는ㄷ', '처럼':'철머'}
TYPO = {
    'ㄱ' : ['ㅅ', 'ㄷ', 'ㄹ'], 'ㅂ' : ['ㅈ', 'ㅁ'], 'ㅈ' : ['ㅂ', 'ㄷ'], 'ㄷ' : ['ㅈ', 'ㄱ'], 'ㅅ': ['ㄱ', 'ㅎ'],
    'ㅁ' : ['ㅂ','ㄴ','ㅋ'], 'ㄴ' : ['ㅈ', 'ㅁ', 'ㅇ'], 'ㅇ' : ['ㄷ', '', 'ㄹ', 'ㄴ'], 'ㄹ' : ['ㅎ', 'ㄱ'], 'ㅎ' : ['ㄹ'],
    'ㅋ' : ['ㅁ', 'ㅌ'], 'ㅌ' : ['ㅋ', 'ㅇ', 'ㅊ'], 'ㅊ' : ['ㅍ', 'ㅌ', 'ㅇ'], 'ㅍ' : ['ㅠ', 'ㅊ', 'ㅎ'],
    'ㅛ' : ['ㅕ', 'ㅗ'], 'ㅕ' : ['ㅛ', 'ㅑ', 'ㅓ'], 'ㅑ' : ['ㅕ', 'ㅐ', 'ㅏ'], 'ㅐ' : ['ㅑ', 'ㅔ', 'ㅒ'], 'ㅒ' : ['ㅐ', 'ㅖ', 'ㅔ'], 'ㅔ' : ['ㅖ', 'ㅐ', 'ㅒ'], 'ㅖ' : ['ㅔ', 'ㅖ', 'ㅐ'],
    'ㅗ' : ['ㅓ', 'ㅛ', 'ㅜ'], 'ㅓ' : ['ㅕ', 'ㅗ', 'ㅏ'], 'ㅏ' : ['ㅓ', 'ㅑ', 'ㅣ'], 'ㅣ' : ['', 'ㅏ'], 'ㅠ' : ['ㅜ','ㅍ'], 'ㅜ' : ['ㅠ', 'ㅡ'], 'ㅡ' : ['ㅜ'],
        }


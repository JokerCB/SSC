/**
 * Created with JetBrains WebStorm.
 * User: Robin
 * Date: 13-5-7
 * Time: 下午3:34
 * 整理登录 js 文件
 */

var jsonParse = (function () {
    var number
        = '(?:-?\\b(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][+-]?[0-9]+)?\\b)';
    var oneChar = '(?:[^\\0-\\x08\\x0a-\\x1f\"\\\\]'
        + '|\\\\(?:[\"/\\\\bfnrt]|u[0-9A-Fa-f]{4}))';
    var string = '(?:\"' + oneChar + '*\")';

    // Will match a value in a well-formed JSON file.
    // If the input is not well-formed, may match strangely, but not in an unsafe
    // way.
    // Since this only matches value tokens, it does not match whitespace, colons,
    // or commas.
    var jsonToken = new RegExp(
        '(?:false|true|null|[\\{\\}\\[\\]]'
            + '|' + number
            + '|' + string
            + ')', 'g');

    // Matches escape sequences in a string literal
    var escapeSequence = new RegExp('\\\\(?:([^u])|u(.{4}))', 'g');

    // Decodes escape sequences in object literals
    var escapes = {
        '"': '"',
        '/': '/',
        '\\': '\\',
        'b': '\b',
        'f': '\f',
        'n': '\n',
        'r': '\r',
        't': '\t'
    };
    function unescapeOne(_, ch, hex) {
        return ch ? escapes[ch] : String.fromCharCode(parseInt(hex, 16));
    }

    // A non-falsy value that coerces to the empty string when used as a key.
    var EMPTY_STRING = new String('');
    var SLASH = '\\';

    // Constructor to use based on an open token.
    var firstTokenCtors = { '{': Object, '[': Array };

    var hop = Object.hasOwnProperty;

    return function (json, opt_reviver) {
        // Split into tokens
        var toks = json.match(jsonToken);
        // Construct the object to return
        var result;
        var tok = toks[0];
        var topLevelPrimitive = false;
        if ('{' === tok) {
            result = {};
        } else if ('[' === tok) {
            result = [];
        } else {
            // The RFC only allows arrays or objects at the top level, but the JSON.parse
            // defined by the EcmaScript 5 draft does allow strings, booleans, numbers, and null
            // at the top level.
            result = [];
            topLevelPrimitive = true;
        }

        // If undefined, the key in an object key/value record to use for the next
        // value parsed.
        var key;
        // Loop over remaining tokens maintaining a stack of uncompleted objects and
        // arrays.
        var stack = [result];
        for (var i = 1 - topLevelPrimitive, n = toks.length; i < n; ++i) {
            tok = toks[i];

            var cont;
            switch (tok.charCodeAt(0)) {
                default:  // sign or digit
                    cont = stack[0];
                    cont[key || cont.length] = +(tok);
                    key = void 0;
                    break;
                case 0x22:  // '"'
                    tok = tok.substring(1, tok.length - 1);
                    if (tok.indexOf(SLASH) !== -1) {
                        tok = tok.replace(escapeSequence, unescapeOne);
                    }
                    cont = stack[0];
                    if (!key) {
                        if (cont instanceof Array) {
                            key = cont.length;
                        } else {
                            key = tok || EMPTY_STRING;  // Use as key for next value seen.
                            break;
                        }
                    }
                    cont[key] = tok;
                    key = void 0;
                    break;
                case 0x5b:  // '['
                    cont = stack[0];
                    stack.unshift(cont[key || cont.length] = []);
                    key = void 0;
                    break;
                case 0x5d:  // ']'
                    stack.shift();
                    break;
                case 0x66:  // 'f'
                    cont = stack[0];
                    cont[key || cont.length] = false;
                    key = void 0;
                    break;
                case 0x6e:  // 'n'
                    cont = stack[0];
                    cont[key || cont.length] = null;
                    key = void 0;
                    break;
                case 0x74:  // 't'
                    cont = stack[0];
                    cont[key || cont.length] = true;
                    key = void 0;
                    break;
                case 0x7b:  // '{'
                    cont = stack[0];
                    stack.unshift(cont[key || cont.length] = {});
                    key = void 0;
                    break;
                case 0x7d:  // '}'
                    stack.shift();
                    break;
            }
        }
        // Fail if we've got an uncompleted object.
        if (topLevelPrimitive) {
            if (stack.length !== 1) { throw new Error(); }
            result = result[0];
        } else {
            if (stack.length) { throw new Error(); }
        }

        if (opt_reviver) {
            var walk = function (holder, key) {
                var value = holder[key];
                if (value && typeof value === 'object') {
                    var toDelete = null;
                    for (var k in value) {
                        if (hop.call(value, k) && value !== holder) {
                            var v = walk(value, k);
                            if (v !== void 0) {
                                value[k] = v;
                            } else {
                                // Deleting properties inside the loop has vaguely defined
                                // semantics in ES3 and ES3.1.
                                if (!toDelete) { toDelete = []; }
                                toDelete.push(k);
                            }
                        }
                    }
                    if (toDelete) {
                        for (var i = toDelete.length; --i >= 0;) {
                            delete value[toDelete[i]];
                        }
                    }
                }
                return opt_reviver.call(holder, key, value);
            };
            result = walk({ '': result }, '');
        }

        return result;
    };
})();

function refreshimg(){
	//$("#validate").attr('src',"/show?"+Math.random());
	$("#validate").attr('src',"/?useValid=true&random="+Math.random());
}

$(function(){
    $(".login_btn").each(function(){
        $(".login_btn").mouseover(function(){
            $(this).css("background-position","left -49px");
        }).mouseout(function(){
            $(this).css("background-position","left top");
        });
    });
	
	$(".login_btn2").each(function(){
		$(".login_btn2").mouseover(function(){
			$(this).css("background-position","left -45px");
		}).mouseout(function(){
			$(this).css("background-position","left top");
		})
	});

	/* 监听回车键 */
	$(document).keydown(function(event){
		if (!$("#JS_blockPage").is(":visible")) {
			if(event.keyCode == 13) {
				LoginNow();
			}
		}
	});
});

function checkclient(){
    setCookie('isclient','1');
}

var setCookie=function(name,value,expire,path){
    //expire=expire||30*24*60*60*1000;
    var curdate=new Date();
    var cookie=name+"="+encodeURIComponent(value)+"; ";
    if(expire!=undefined||expire==0){
        if(expire==-1){
            expire=366*86400*1000;//保存一年
        }else{
            expire=parseInt(expire);
        }
        curdate.setTime(curdate.getTime()+expire);
        cookie+="expires="+curdate.toUTCString()+"; ";
    }
    path=path||"/";
    cookie+="path="+path;
    document.cookie=cookie;
};
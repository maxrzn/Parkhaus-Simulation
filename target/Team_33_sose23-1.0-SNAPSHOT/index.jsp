<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>




<!DOCTYPE html>
<html>
<head>
    <title>Parkhaus Eingang
    </title>
    <style>
        html {
            text-align: center;
        }
        h1 {
            text-align: center;
            font-size: xx-large;
            color:black;
        }

        body {
            width:80%;
            margin-left:auto;
            margin-right:auto;
            background-image: url('https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/1200px-Flag_of_the_People%27s_Republic_of_China.svg.png');
            background-repeat: no-repeat;
            background-attachment: fixed;
            background-size: 100% 100%;
        }
        a:link {
            color:yellow;
        }
        a:hover {
            color:black;
        }
        a:visited {
            color:yellow;
        }
        a:visited:hover {
            color:black;
        }

        .blink {
            animation: blinker 2s linear infinite;
            color: black;
            font-family: sans-serif;
        }
        @keyframes blinker {
            50% {
                opacity: 0.3;
            }
        }
    </style>
</head>
<body>
<!--<script>
    function play() {
        var audio = document.getElementbyId("audio");
        audio.play();
        }
</script>-->

<p class="blink" id="achtung" style="background-color:white; font-size:20px; color:black;"> Achtung!!! <br>Vorm Parkhaus Eingang steht ein fremder Mann der sie nicht durchlässt und ihnen Fast & Furious 9 verkaufen will.<br> Ein Eis könnte ihn vielleicht umstimmen...</p>
<br><br>
<h1>
    現在我有冰淇淋
    我很喜歡冰淇淋
    但是
    《速度與激情9》
    比冰淇淋
    《速度與激-》
    《速度與激情9》
    我最喜歡
    所以現在是
    音樂時間
    準備

    一
    二
    三

    兩個禮拜以後
    《速度與激情9》
    兩個禮拜以後
    《速度與激情9》
    兩個禮拜以後
    《速度與激情9》

    不要忘記
    不要錯過
    去電影院
    看《速度與激情9》
    因為非常好電影
    動作非常好
    差不多一樣「冰激淋」
    再見
</h1>
<br>
<h1>
    <!--<input align="center" type="button" value="PLAY" onclick="play()">
    <audio id="audio" src="https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3" ></audio>-->
    <table align="center">
        <tr>
            <td>
                <img src="data:image/jpeg;base64,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">
            </td>
            <td>
                &nbsp;&nbsp;&nbsp;
            </td>
            <td>
                <iframe scrolling="no" width="110" height="125" src="https://www.voicy.network/embed/rfyYCc3t6EWCnwAtJAsE9Q"></iframe><br>
                <a href="ParkHausWeb">BING CHILLING</a>

            </td>
            <td>
                &nbsp;&nbsp;&nbsp;
            </td>
            <td>
                <img src="data:image/jpeg;base64,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">
            </td>
        </tr>
    </table>
</h1>
<h1>
    Zǎo shang hǎo zhōng guó!
    Xiàn zài wǒ yǒu bing chilling
    Wǒ hěn xǐ huān bing chilling
    Dàn shì "sù dù yǔ jī qíng jiǔ" bǐ bing chilling
    "sù dù yǔ jī qíng, sù dù yǔ jī qíng jiǔ"
    Wǒ zuì xǐ huān
    Suǒ yǐ xiàn zài shì yīn yuè shí jiān
    Zhǔn bèi
    Yī, èr, sān Liǎng gè lǐ bài yǐ hòu
    "Sù dù yǔ jī qíng jiǔ"
    Liǎng gè lǐ bài yǐ hòu
    "Sù dù yǔ jī qíng jiǔ"
    Liǎng gè lǐ bài yǐ hòu
    "Sù dù yǔ jī qíng jiǔ"
    Bù yào wàng jì, bù yào cuò guò
    Jì dé qù diàn yǐng yuàn kàn "sù dù yǔ jī qíng jiǔ"
    Yīn wéi fēi cháng hǎo diàn yǐng
    Dòng zuò fēi cháng hǎo
    Chà bù duō yī yàng bing chilling
    Zài jiàn
</h1>
</body>
</html>
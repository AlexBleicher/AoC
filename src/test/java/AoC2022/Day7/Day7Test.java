package AoC2022.Day7;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Day7Test {

    @ParameterizedTest
    @MethodSource
    public void task1(String input, long expected){
        Day7 testObject= new Day7(input);
        long result = testObject.task1();

        assertEquals(expected, result);
    }

    public static Stream<Arguments> task1(){
        return Stream.of(
                Arguments.of("$ cd /\n" +
                        "$ ls\n" +
                        "dir a\n" +
                        "14848514 b.txt\n" +
                        "8504156 c.dat\n" +
                        "dir d\n" +
                        "$ cd a\n" +
                        "$ ls\n" +
                        "dir e\n" +
                        "29116 f\n" +
                        "2557 g\n" +
                        "62596 h.lst\n" +
                        "$ cd e\n" +
                        "$ ls\n" +
                        "584 i\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd d\n" +
                        "$ ls\n" +
                        "4060174 j\n" +
                        "8033020 d.log\n" +
                        "5626152 d.ext\n" +
                        "7214296 k", 95437),
                Arguments.of("$ cd /\n" +
                        "$ ls\n" +
                        "dir bcfwbq\n" +
                        "14779 cmss\n" +
                        "dir ctctt\n" +
                        "101350 gpbswq.njr\n" +
                        "270744 mglrchsr\n" +
                        "260405 qtvftbl\n" +
                        "dir rbsrpg\n" +
                        "dir rzgnbgv\n" +
                        "dir svsgnbs\n" +
                        "dir wqctlzz\n" +
                        "71582 wrqbm\n" +
                        "$ cd bcfwbq\n" +
                        "$ ls\n" +
                        "dir bsbpc\n" +
                        "dir gpbswq\n" +
                        "172204 lpn.qjd\n" +
                        "269121 lts.zjd\n" +
                        "dir pfps\n" +
                        "dir phvgmv\n" +
                        "dir pjcrwh\n" +
                        "dir pvf\n" +
                        "dir rthpbmhr\n" +
                        "dir sjnvdz\n" +
                        "$ cd bsbpc\n" +
                        "$ ls\n" +
                        "191305 hlqptq.nrj\n" +
                        "15627 lts.zjd\n" +
                        "$ cd ..\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "dir ctctt\n" +
                        "dir jcw\n" +
                        "dir jnh\n" +
                        "53143 lts.zjd\n" +
                        "dir qrrjgdbd\n" +
                        "dir tnsjg\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "dir hhmm\n" +
                        "$ cd hhmm\n" +
                        "$ ls\n" +
                        "89761 brfjczv.lmr\n" +
                        "226384 gwqfwwp.ctl\n" +
                        "174778 pgsdmfj\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd jcw\n" +
                        "$ ls\n" +
                        "149585 gpbswq.lbv\n" +
                        "$ cd ..\n" +
                        "$ cd jnh\n" +
                        "$ ls\n" +
                        "10840 ctctt\n" +
                        "dir fzplg\n" +
                        "dir jvpc\n" +
                        "dir lpn\n" +
                        "dir mcz\n" +
                        "48063 nczc\n" +
                        "8024 rthpbmhr.qwq\n" +
                        "65222 vqgbgm\n" +
                        "$ cd fzplg\n" +
                        "$ ls\n" +
                        "34828 lpn.vcl\n" +
                        "dir svsgnbs\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "216427 bvtl\n" +
                        "242012 gpbswq.qlg\n" +
                        "dir gsmltmw\n" +
                        "11388 lpn.trp\n" +
                        "dir lrr\n" +
                        "dir vwqlvj\n" +
                        "$ cd gsmltmw\n" +
                        "$ ls\n" +
                        "66467 pldhhjch\n" +
                        "$ cd ..\n" +
                        "$ cd lrr\n" +
                        "$ ls\n" +
                        "dir ctctt\n" +
                        "dir lpn\n" +
                        "16831 lts.zjd\n" +
                        "dir svsgnbs\n" +
                        "dir tdpmdfgd\n" +
                        "177469 wct.njp\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "145394 phd.tvj\n" +
                        "$ cd ..\n" +
                        "$ cd lpn\n" +
                        "$ ls\n" +
                        "dir svsgnbs\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "148504 ctctt.vjd\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "245750 ggbhsgz.snc\n" +
                        "$ cd ..\n" +
                        "$ cd tdpmdfgd\n" +
                        "$ ls\n" +
                        "dir cghfclv\n" +
                        "dir mcfzvlvw\n" +
                        "dir mdgvcgbc\n" +
                        "$ cd cghfclv\n" +
                        "$ ls\n" +
                        "49162 shwslwsf.lww\n" +
                        "$ cd ..\n" +
                        "$ cd mcfzvlvw\n" +
                        "$ ls\n" +
                        "dir bsbswh\n" +
                        "$ cd bsbswh\n" +
                        "$ ls\n" +
                        "dir hqsdsp\n" +
                        "$ cd hqsdsp\n" +
                        "$ ls\n" +
                        "70065 pldhhjch\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd mdgvcgbc\n" +
                        "$ ls\n" +
                        "235514 dhfms.nwl\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd vwqlvj\n" +
                        "$ ls\n" +
                        "269473 jwv.dqh\n" +
                        "90324 mglrchsr\n" +
                        "194977 rwgsvszh.jbf\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd jvpc\n" +
                        "$ ls\n" +
                        "dir rdgqr\n" +
                        "dir sspn\n" +
                        "$ cd rdgqr\n" +
                        "$ ls\n" +
                        "dir qcjccsth\n" +
                        "$ cd qcjccsth\n" +
                        "$ ls\n" +
                        "dir rqwvslc\n" +
                        "$ cd rqwvslc\n" +
                        "$ ls\n" +
                        "275985 pgqph.lcn\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd sspn\n" +
                        "$ ls\n" +
                        "200316 gpbswq\n" +
                        "162820 pldhhjch\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd lpn\n" +
                        "$ ls\n" +
                        "277995 hlqptq.nrj\n" +
                        "$ cd ..\n" +
                        "$ cd mcz\n" +
                        "$ ls\n" +
                        "dir fjtj\n" +
                        "157693 gqfgrfqw.wtc\n" +
                        "dir jqbpcd\n" +
                        "206235 lpn\n" +
                        "54229 mglrchsr\n" +
                        "238506 rthpbmhr\n" +
                        "dir snr\n" +
                        "dir ztlrtgjl\n" +
                        "$ cd fjtj\n" +
                        "$ ls\n" +
                        "240610 fbwzn\n" +
                        "207688 hlqptq.nrj\n" +
                        "150032 lts.zjd\n" +
                        "48060 mcrgn\n" +
                        "265551 zqrnt.srf\n" +
                        "$ cd ..\n" +
                        "$ cd jqbpcd\n" +
                        "$ ls\n" +
                        "256141 ctctt.nbp\n" +
                        "dir gpbswq\n" +
                        "78480 hmddcjdd.bmc\n" +
                        "31403 lpn\n" +
                        "120619 mvdfjzdr\n" +
                        "dir nqgvl\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "125791 ctctt\n" +
                        "$ cd ..\n" +
                        "$ cd nqgvl\n" +
                        "$ ls\n" +
                        "174465 jrbfcvf.rqr\n" +
                        "144210 lts.zjd\n" +
                        "258976 rthpbmhr\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd snr\n" +
                        "$ ls\n" +
                        "185943 rthpbmhr.jhb\n" +
                        "$ cd ..\n" +
                        "$ cd ztlrtgjl\n" +
                        "$ ls\n" +
                        "232309 ntlzfsz.vjd\n" +
                        "254942 zhrds.nbp\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd qrrjgdbd\n" +
                        "$ ls\n" +
                        "dir gpbswq\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "170768 rthpbmhr.qwf\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd tnsjg\n" +
                        "$ ls\n" +
                        "242206 bjmgvmp.hht\n" +
                        "245356 frtdp\n" +
                        "dir jrflhz\n" +
                        "128115 lpn\n" +
                        "120081 rfhs\n" +
                        "dir sfplvt\n" +
                        "dir tts\n" +
                        "114165 zfl.ccr\n" +
                        "$ cd jrflhz\n" +
                        "$ ls\n" +
                        "dir gpbswq\n" +
                        "dir nnlzjwts\n" +
                        "dir sctf\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "121401 mglrchsr\n" +
                        "$ cd ..\n" +
                        "$ cd nnlzjwts\n" +
                        "$ ls\n" +
                        "dir gljnss\n" +
                        "165011 lts.zjd\n" +
                        "69364 svsgnbs.bqm\n" +
                        "$ cd gljnss\n" +
                        "$ ls\n" +
                        "181850 cfjbd.fmj\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd sctf\n" +
                        "$ ls\n" +
                        "109435 gqfgrfqw.wtc\n" +
                        "146343 lpn.mbs\n" +
                        "255948 svsgnbs.hbf\n" +
                        "231472 vdrfwqwv.pzf\n" +
                        "263352 zgzj\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd sfplvt\n" +
                        "$ ls\n" +
                        "51580 hlqptq.nrj\n" +
                        "dir mldph\n" +
                        "$ cd mldph\n" +
                        "$ ls\n" +
                        "163815 hsnw\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd tts\n" +
                        "$ ls\n" +
                        "dir ctctt\n" +
                        "211239 rpm\n" +
                        "dir rthpbmhr\n" +
                        "dir wpnnrzb\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "dir ctctt\n" +
                        "137333 hshpfwl\n" +
                        "183146 srd\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "89470 hlqptq.nrj\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd rthpbmhr\n" +
                        "$ ls\n" +
                        "139569 fhjlbrmp.phd\n" +
                        "223589 jvrs.bpj\n" +
                        "198566 rthpbmhr.qdr\n" +
                        "$ cd ..\n" +
                        "$ cd wpnnrzb\n" +
                        "$ ls\n" +
                        "dir ctctt\n" +
                        "158058 fjtcc\n" +
                        "dir jqqhgjv\n" +
                        "dir qvbvvb\n" +
                        "16429 wds.hpj\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "166551 gcjt.wld\n" +
                        "233189 gpbswq.mls\n" +
                        "193694 rthpbmhr.rvz\n" +
                        "dir svsgnbs\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "248185 fpssfvd.zft\n" +
                        "215781 rwtg.gch\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd jqqhgjv\n" +
                        "$ ls\n" +
                        "dir gpbswq\n" +
                        "14842 lts.zjd\n" +
                        "dir mqp\n" +
                        "258342 pldhhjch\n" +
                        "103492 sddj.sbq\n" +
                        "248024 svsgnbs\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "dir sqchbqc\n" +
                        "176209 vdq.jbz\n" +
                        "$ cd sqchbqc\n" +
                        "$ ls\n" +
                        "dir cphf\n" +
                        "$ cd cphf\n" +
                        "$ ls\n" +
                        "253613 snzbgfs.rjf\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd mqp\n" +
                        "$ ls\n" +
                        "10090 mfw\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd qvbvvb\n" +
                        "$ ls\n" +
                        "dir mzw\n" +
                        "dir svsgnbs\n" +
                        "$ cd mzw\n" +
                        "$ ls\n" +
                        "98994 mmv.hcl\n" +
                        "$ cd ..\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "108748 lts.zjd\n" +
                        "10351 mglrchsr\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd pfps\n" +
                        "$ ls\n" +
                        "dir cpp\n" +
                        "110535 mglrchsr\n" +
                        "120669 qvh.fbm\n" +
                        "$ cd cpp\n" +
                        "$ ls\n" +
                        "dir htnmrjpq\n" +
                        "$ cd htnmrjpq\n" +
                        "$ ls\n" +
                        "120225 bdjmsbg.wfz\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd phvgmv\n" +
                        "$ ls\n" +
                        "113550 pldhhjch\n" +
                        "31171 zcfm\n" +
                        "$ cd ..\n" +
                        "$ cd pjcrwh\n" +
                        "$ ls\n" +
                        "265625 snbjdmg.jtn\n" +
                        "$ cd ..\n" +
                        "$ cd pvf\n" +
                        "$ ls\n" +
                        "91010 ctctt\n" +
                        "dir hdz\n" +
                        "dir qtwfpmvz\n" +
                        "$ cd hdz\n" +
                        "$ ls\n" +
                        "103787 rlnrs\n" +
                        "$ cd ..\n" +
                        "$ cd qtwfpmvz\n" +
                        "$ ls\n" +
                        "244905 lts.zjd\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd rthpbmhr\n" +
                        "$ ls\n" +
                        "dir phq\n" +
                        "dir svsgnbs\n" +
                        "dir wzwfz\n" +
                        "dir zpwfj\n" +
                        "$ cd phq\n" +
                        "$ ls\n" +
                        "91709 bzfnqh\n" +
                        "dir ccwqrjn\n" +
                        "dir gpbswq\n" +
                        "dir svsgnbs\n" +
                        "$ cd ccwqrjn\n" +
                        "$ ls\n" +
                        "8953 fffqzmqp\n" +
                        "dir ftnb\n" +
                        "dir svsgnbs\n" +
                        "$ cd ftnb\n" +
                        "$ ls\n" +
                        "226615 rthpbmhr\n" +
                        "$ cd ..\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "dir bhnnm\n" +
                        "dir tjrqtmd\n" +
                        "$ cd bhnnm\n" +
                        "$ ls\n" +
                        "dir prfqw\n" +
                        "$ cd prfqw\n" +
                        "$ ls\n" +
                        "dir hzsjlq\n" +
                        "$ cd hzsjlq\n" +
                        "$ ls\n" +
                        "99285 cfpwbvp\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd tjrqtmd\n" +
                        "$ ls\n" +
                        "237461 cqr.wfj\n" +
                        "149955 zchnb\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "dir bqqtnfb\n" +
                        "dir ctctt\n" +
                        "261108 gpbswq\n" +
                        "135193 hnrflng\n" +
                        "264503 jrp.bls\n" +
                        "224864 mghhgrj.tgp\n" +
                        "dir pljbtbn\n" +
                        "dir rthpbmhr\n" +
                        "244222 svsgnbs.rzp\n" +
                        "$ cd bqqtnfb\n" +
                        "$ ls\n" +
                        "dir jnzfr\n" +
                        "$ cd jnzfr\n" +
                        "$ ls\n" +
                        "dir bdrqmr\n" +
                        "168907 pldhhjch\n" +
                        "$ cd bdrqmr\n" +
                        "$ ls\n" +
                        "151767 vfw.jjc\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "dir zdsshmr\n" +
                        "$ cd zdsshmr\n" +
                        "$ ls\n" +
                        "77208 hlqptq.nrj\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd pljbtbn\n" +
                        "$ ls\n" +
                        "63719 hlqptq.nrj\n" +
                        "103719 jjctg.dhw\n" +
                        "547 tljz.wnv\n" +
                        "$ cd ..\n" +
                        "$ cd rthpbmhr\n" +
                        "$ ls\n" +
                        "dir sjbfhcpc\n" +
                        "$ cd sjbfhcpc\n" +
                        "$ ls\n" +
                        "184946 sgpgszw\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "dir ctctt\n" +
                        "dir flzsvb\n" +
                        "dir pbw\n" +
                        "23408 qprlnvwv.jmz\n" +
                        "dir wjhplc\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "11507 cnf\n" +
                        "dir gpbswq\n" +
                        "87778 rthpbmhr.wzv\n" +
                        "dir slmbb\n" +
                        "dir sqc\n" +
                        "75556 wsbzwn.mpf\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "173498 dsg\n" +
                        "202811 msvs.szd\n" +
                        "208419 pldhhjch\n" +
                        "$ cd ..\n" +
                        "$ cd slmbb\n" +
                        "$ ls\n" +
                        "dir jcth\n" +
                        "dir njldhbln\n" +
                        "$ cd jcth\n" +
                        "$ ls\n" +
                        "6106 hlqptq.nrj\n" +
                        "$ cd ..\n" +
                        "$ cd njldhbln\n" +
                        "$ ls\n" +
                        "241153 mvnvzqfc.rtn\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd sqc\n" +
                        "$ ls\n" +
                        "dir zhrc\n" +
                        "$ cd zhrc\n" +
                        "$ ls\n" +
                        "dir qswqqzb\n" +
                        "$ cd qswqqzb\n" +
                        "$ ls\n" +
                        "264937 btqmqn.hqv\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd flzsvb\n" +
                        "$ ls\n" +
                        "58735 hlqptq.nrj\n" +
                        "$ cd ..\n" +
                        "$ cd pbw\n" +
                        "$ ls\n" +
                        "80787 bgfmdg\n" +
                        "234807 gqfgrfqw.wtc\n" +
                        "44816 pldhhjch\n" +
                        "dir qjjpmq\n" +
                        "dir rthpbmhr\n" +
                        "153500 ssmdz\n" +
                        "$ cd qjjpmq\n" +
                        "$ ls\n" +
                        "155209 ctghhsdh\n" +
                        "182544 fprdp.ffs\n" +
                        "$ cd ..\n" +
                        "$ cd rthpbmhr\n" +
                        "$ ls\n" +
                        "136673 lts.zjd\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd wjhplc\n" +
                        "$ ls\n" +
                        "246593 hhcgnfjb.nbl\n" +
                        "29266 hlqptq.nrj\n" +
                        "246096 lts.zjd\n" +
                        "40242 rrfgvvhg\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "215743 fwm\n" +
                        "236816 gqfgrfqw.wtc\n" +
                        "235185 sjdlr.rzj\n" +
                        "dir ztsgb\n" +
                        "$ cd ztsgb\n" +
                        "$ ls\n" +
                        "265998 rthpbmhr.pdp\n" +
                        "275979 zqfcprz.wtd\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd wzwfz\n" +
                        "$ ls\n" +
                        "dir bsqwtf\n" +
                        "dir ctctt\n" +
                        "dir lpng\n" +
                        "dir svsgnbs\n" +
                        "$ cd bsqwtf\n" +
                        "$ ls\n" +
                        "dir rhjb\n" +
                        "dir sgzvb\n" +
                        "$ cd rhjb\n" +
                        "$ ls\n" +
                        "166599 rthpbmhr.msg\n" +
                        "$ cd ..\n" +
                        "$ cd sgzvb\n" +
                        "$ ls\n" +
                        "185594 zmnb.bcq\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "130367 svsgnbs\n" +
                        "17459 tdsztr.fsn\n" +
                        "242273 wfs\n" +
                        "$ cd ..\n" +
                        "$ cd lpng\n" +
                        "$ ls\n" +
                        "145778 snmcwfg.hjz\n" +
                        "$ cd ..\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "dir ctctt\n" +
                        "dir nqrlzg\n" +
                        "dir qczmdfm\n" +
                        "54814 wtmjh.jdv\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "244171 pldhhjch\n" +
                        "$ cd ..\n" +
                        "$ cd nqrlzg\n" +
                        "$ ls\n" +
                        "dir qjhlj\n" +
                        "$ cd qjhlj\n" +
                        "$ ls\n" +
                        "dir gncct\n" +
                        "$ cd gncct\n" +
                        "$ ls\n" +
                        "141943 wsdgmdd.ctz\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd qczmdfm\n" +
                        "$ ls\n" +
                        "4482 lpn.fmp\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd zpwfj\n" +
                        "$ ls\n" +
                        "226995 lts.zjd\n" +
                        "dir sflcgdm\n" +
                        "$ cd sflcgdm\n" +
                        "$ ls\n" +
                        "199168 bjrjrrm.bfw\n" +
                        "dir fpcq\n" +
                        "24906 gdzfmhz.jhp\n" +
                        "7267 hdpzvh.ngg\n" +
                        "dir jjsgqb\n" +
                        "137796 psws.hvp\n" +
                        "$ cd fpcq\n" +
                        "$ ls\n" +
                        "195792 nghcc.wps\n" +
                        "$ cd ..\n" +
                        "$ cd jjsgqb\n" +
                        "$ ls\n" +
                        "18774 ctctt\n" +
                        "106399 jvbgfhs\n" +
                        "208035 rthpbmhr\n" +
                        "dir zptz\n" +
                        "$ cd zptz\n" +
                        "$ ls\n" +
                        "278792 gqfgrfqw.wtc\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd sjnvdz\n" +
                        "$ ls\n" +
                        "dir fchgggp\n" +
                        "dir gldg\n" +
                        "40164 gnh.gmv\n" +
                        "dir lpn\n" +
                        "dir njtgjt\n" +
                        "81415 qqfm.grb\n" +
                        "dir vvcbjct\n" +
                        "$ cd fchgggp\n" +
                        "$ ls\n" +
                        "dir fjcclj\n" +
                        "dir lpn\n" +
                        "145291 lts.zjd\n" +
                        "7288 mglrchsr\n" +
                        "dir pmhdzvfn\n" +
                        "dir qtpdfwh\n" +
                        "dir vjwtvb\n" +
                        "$ cd fjcclj\n" +
                        "$ ls\n" +
                        "28333 gpbswq.vtg\n" +
                        "258676 lts.zjd\n" +
                        "$ cd ..\n" +
                        "$ cd lpn\n" +
                        "$ ls\n" +
                        "197797 pldhhjch\n" +
                        "$ cd ..\n" +
                        "$ cd pmhdzvfn\n" +
                        "$ ls\n" +
                        "21538 gpbswq.pwq\n" +
                        "5451 hqjg\n" +
                        "dir llhp\n" +
                        "220717 lzqmh.stl\n" +
                        "123800 pldhhjch\n" +
                        "dir pmv\n" +
                        "dir rzs\n" +
                        "dir tztv\n" +
                        "160018 zfvgjtzr.qth\n" +
                        "$ cd llhp\n" +
                        "$ ls\n" +
                        "dir lsft\n" +
                        "dir pfjmphs\n" +
                        "$ cd lsft\n" +
                        "$ ls\n" +
                        "78424 gpbswq.ddb\n" +
                        "101497 gqfgrfqw.wtc\n" +
                        "137686 hlqptq.nrj\n" +
                        "122325 mglrchsr\n" +
                        "$ cd ..\n" +
                        "$ cd pfjmphs\n" +
                        "$ ls\n" +
                        "185141 mbw.gnd\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd pmv\n" +
                        "$ ls\n" +
                        "139255 gqfgrfqw.wtc\n" +
                        "272882 hlqptq.nrj\n" +
                        "$ cd ..\n" +
                        "$ cd rzs\n" +
                        "$ ls\n" +
                        "dir gpbswq\n" +
                        "89153 gpbswq.vcv\n" +
                        "81882 gqfgrfqw.wtc\n" +
                        "39252 hlqptq.nrj\n" +
                        "dir tmcm\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "205674 ctctt.gqd\n" +
                        "$ cd ..\n" +
                        "$ cd tmcm\n" +
                        "$ ls\n" +
                        "156591 gmjvzj.wzl\n" +
                        "199254 lts.zjd\n" +
                        "dir vzhbsdd\n" +
                        "dir zfs\n" +
                        "$ cd vzhbsdd\n" +
                        "$ ls\n" +
                        "70059 gsgzqgn.fhf\n" +
                        "43456 hrttvrqc\n" +
                        "$ cd ..\n" +
                        "$ cd zfs\n" +
                        "$ ls\n" +
                        "223726 hlqptq.nrj\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd tztv\n" +
                        "$ ls\n" +
                        "200126 lpn.bns\n" +
                        "dir wfjwmbj\n" +
                        "$ cd wfjwmbj\n" +
                        "$ ls\n" +
                        "120344 gdqgml.gdn\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd qtpdfwh\n" +
                        "$ ls\n" +
                        "dir qszjt\n" +
                        "$ cd qszjt\n" +
                        "$ ls\n" +
                        "7207 rthpbmhr.rpv\n" +
                        "20452 ztdnfmgp.dsb\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd vjwtvb\n" +
                        "$ ls\n" +
                        "dir scswlmn\n" +
                        "$ cd scswlmn\n" +
                        "$ ls\n" +
                        "207195 svsgnbs.jqq\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd gldg\n" +
                        "$ ls\n" +
                        "119560 ctctt.wbc\n" +
                        "203041 gqfgrfqw.wtc\n" +
                        "dir hrp\n" +
                        "274270 lts.zjd\n" +
                        "25081 mhsfdhjr.ndw\n" +
                        "dir svsgnbs\n" +
                        "$ cd hrp\n" +
                        "$ ls\n" +
                        "dir lpn\n" +
                        "$ cd lpn\n" +
                        "$ ls\n" +
                        "dir gpbswq\n" +
                        "dir wvrzhdb\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "dir vtgc\n" +
                        "$ cd vtgc\n" +
                        "$ ls\n" +
                        "231107 hlqptq.nrj\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd wvrzhdb\n" +
                        "$ ls\n" +
                        "83303 lts.zjd\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "dir fhfqlv\n" +
                        "13446 frn.hzg\n" +
                        "126475 wmjjjl.cjr\n" +
                        "$ cd fhfqlv\n" +
                        "$ ls\n" +
                        "243574 hjn.jzb\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd lpn\n" +
                        "$ ls\n" +
                        "dir mqglznd\n" +
                        "$ cd mqglznd\n" +
                        "$ ls\n" +
                        "dir gpbswq\n" +
                        "177654 gpbswq.zhv\n" +
                        "128217 gqfgrfqw.wtc\n" +
                        "66750 hlqptq.nrj\n" +
                        "136018 hvphz\n" +
                        "dir pswvwtf\n" +
                        "113363 rthpbmhr.gwz\n" +
                        "dir twddrn\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "244278 lts.zjd\n" +
                        "dir pfrjwbvl\n" +
                        "dir qlrfw\n" +
                        "222491 rthpbmhr\n" +
                        "$ cd pfrjwbvl\n" +
                        "$ ls\n" +
                        "46802 cfl.ljt\n" +
                        "dir ctctt\n" +
                        "dir dfqzmd\n" +
                        "110525 gshdhsfm\n" +
                        "dir jcbw\n" +
                        "dir lpn\n" +
                        "237385 pldhhjch\n" +
                        "15812 prcwhhq.jjh\n" +
                        "dir rthpbmhr\n" +
                        "260693 zmgq\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "6529 hctcg.dpw\n" +
                        "188655 lpn.qjf\n" +
                        "202221 wjnb\n" +
                        "$ cd ..\n" +
                        "$ cd dfqzmd\n" +
                        "$ ls\n" +
                        "197980 ctctt\n" +
                        "$ cd ..\n" +
                        "$ cd jcbw\n" +
                        "$ ls\n" +
                        "1281 gpbswq\n" +
                        "15778 jfgjlcd.mqh\n" +
                        "38803 mdtcrb.dbj\n" +
                        "dir qtjbpbs\n" +
                        "$ cd qtjbpbs\n" +
                        "$ ls\n" +
                        "59348 mglrchsr\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd lpn\n" +
                        "$ ls\n" +
                        "dir ctctt\n" +
                        "dir hsjjp\n" +
                        "260465 mglrchsr\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "dir wvbrsb\n" +
                        "$ cd wvbrsb\n" +
                        "$ ls\n" +
                        "135584 lts.zjd\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd hsjjp\n" +
                        "$ ls\n" +
                        "249448 ddfqnwgf\n" +
                        "164051 dsnhsbp.wvv\n" +
                        "dir fmzgm\n" +
                        "dir gpbswq\n" +
                        "113907 gqfgrfqw.wtc\n" +
                        "$ cd fmzgm\n" +
                        "$ ls\n" +
                        "150025 ngnqjcj.tbf\n" +
                        "$ cd ..\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "33139 dmgqhf.nzd\n" +
                        "dir gpbswq\n" +
                        "dir rwd\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "148820 lnqqds.rpg\n" +
                        "$ cd ..\n" +
                        "$ cd rwd\n" +
                        "$ ls\n" +
                        "133433 pldhhjch\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd rthpbmhr\n" +
                        "$ ls\n" +
                        "262342 fdnr.svq\n" +
                        "dir nbpsdm\n" +
                        "161791 pldhhjch\n" +
                        "6835 qvclr\n" +
                        "228110 whf\n" +
                        "$ cd nbpsdm\n" +
                        "$ ls\n" +
                        "dir rthpbmhr\n" +
                        "dir svsgnbs\n" +
                        "$ cd rthpbmhr\n" +
                        "$ ls\n" +
                        "267109 chb\n" +
                        "$ cd ..\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "150446 rlv.vcc\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd qlrfw\n" +
                        "$ ls\n" +
                        "dir sgcpwst\n" +
                        "$ cd sgcpwst\n" +
                        "$ ls\n" +
                        "dir fss\n" +
                        "$ cd fss\n" +
                        "$ ls\n" +
                        "244165 gpbswq.qtz\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd pswvwtf\n" +
                        "$ ls\n" +
                        "162099 jhdrnv.zrd\n" +
                        "54856 mglrchsr\n" +
                        "dir psdz\n" +
                        "169053 qhq\n" +
                        "$ cd psdz\n" +
                        "$ ls\n" +
                        "dir lbcf\n" +
                        "$ cd lbcf\n" +
                        "$ ls\n" +
                        "218770 ctctt.chv\n" +
                        "95266 pldhhjch\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd twddrn\n" +
                        "$ ls\n" +
                        "120791 hlqptq.nrj\n" +
                        "212213 vffj\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd njtgjt\n" +
                        "$ ls\n" +
                        "dir mzwdb\n" +
                        "$ cd mzwdb\n" +
                        "$ ls\n" +
                        "108520 lts.zjd\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd vvcbjct\n" +
                        "$ ls\n" +
                        "155890 ctctt.fbw\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "5656 mpftwp.nds\n" +
                        "8998 pldhhjch\n" +
                        "185601 snrng.qsv\n" +
                        "$ cd ..\n" +
                        "$ cd rbsrpg\n" +
                        "$ ls\n" +
                        "113129 cpwmjw.rbj\n" +
                        "dir jdhmlzr\n" +
                        "114254 sqj.fzp\n" +
                        "120708 svsgnbs.hpn\n" +
                        "$ cd jdhmlzr\n" +
                        "$ ls\n" +
                        "dir cdnmflmm\n" +
                        "248055 hlqptq.nrj\n" +
                        "247942 pldhhjch\n" +
                        "dir qrwsnzdv\n" +
                        "80053 svsgnbs\n" +
                        "219309 zhqgvd.bhw\n" +
                        "$ cd cdnmflmm\n" +
                        "$ ls\n" +
                        "83138 lpn.wtg\n" +
                        "$ cd ..\n" +
                        "$ cd qrwsnzdv\n" +
                        "$ ls\n" +
                        "197145 zspfb.sbd\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd rzgnbgv\n" +
                        "$ ls\n" +
                        "208692 clz\n" +
                        "dir tmcqcpfc\n" +
                        "dir twlnjr\n" +
                        "$ cd tmcqcpfc\n" +
                        "$ ls\n" +
                        "dir jtnf\n" +
                        "$ cd jtnf\n" +
                        "$ ls\n" +
                        "242978 fhvtvdff.swr\n" +
                        "21748 lwcplzmw\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd twlnjr\n" +
                        "$ ls\n" +
                        "dir ctctt\n" +
                        "dir gpbswq\n" +
                        "98435 rthpbmhr.pcr\n" +
                        "dir snpm\n" +
                        "dir svsgnbs\n" +
                        "104969 zzd\n" +
                        "$ cd ctctt\n" +
                        "$ ls\n" +
                        "200382 pqswsnhp\n" +
                        "$ cd ..\n" +
                        "$ cd gpbswq\n" +
                        "$ ls\n" +
                        "90380 qqrfbwn\n" +
                        "$ cd ..\n" +
                        "$ cd snpm\n" +
                        "$ ls\n" +
                        "57996 swfjlfh.qft\n" +
                        "$ cd ..\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "86028 clcfrnr.jwl\n" +
                        "199666 ctctt.ftr\n" +
                        "200949 ctctt.mrh\n" +
                        "23594 dhlmbh.gjt\n" +
                        "278047 mbchg\n" +
                        "dir pgfhp\n" +
                        "$ cd pgfhp\n" +
                        "$ ls\n" +
                        "21555 rlblnvsd\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd ..\n" +
                        "$ cd svsgnbs\n" +
                        "$ ls\n" +
                        "155183 jgjj.sgs\n" +
                        "28150 pldhhjch\n" +
                        "$ cd ..\n" +
                        "$ cd wqctlzz\n" +
                        "$ ls\n" +
                        "23662 mglrchsr\n" +
                        "60923 pldhhjch", 0)
        );
    }

}
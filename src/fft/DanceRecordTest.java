package fft;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

public class DanceRecordTest {

	private static float[] zs1 = {(float) 2.514909, (float) 2.5458746, (float) 2.6469429, (float) 2.8878028, (float) 3.294381407179586, (float) 3.8478001071795864, (float) 4.327620907179586, (float) 4.4459557071795865, (float) 4.363974507179586, (float) 4.306567307179586, (float) 4.243871507179586, (float) 4.043820407179586, (float) 3.644182307179586, (float) 3.1884142071795862, (float) 2.9158187, (float) 2.878709, (float) 2.8712478, (float) 2.856895, (float) 2.8856266, (float) 2.940194, (float) 3.212277507179586, (float) 3.756549207179586, (float) 4.319415607179586, (float) 4.552972507179586, (float) 4.474068707179586, (float) 4.430378107179586, (float) 4.462398307179586, (float) 4.369710607179586, (float) 3.625023707179586, (float) 3.1172192, (float) 2.8414152, (float) 2.7809196, (float) 2.7839465, (float) 2.800671, (float) 2.7938335, (float) 2.8378587, (float) 3.0290337, (float) 3.610400307179586, (float) 4.299749307179586, (float) 4.549540707179586, (float) 4.442579307179586, (float) 4.398001407179587, (float) 4.457092507179587, (float) 4.351394007179586, (float) 4.047479407179586, (float) 3.5441747071795864, (float) 2.9527786, (float) 2.5554326, (float) 2.4418573, (float) 2.4038644, (float) 2.5507576, (float) 2.8071609, (float) 3.4445923071795863, (float) 4.1785219071795865, (float) 4.424250207179586, (float) 4.392989707179586, (float) 4.409736507179586, (float) 4.418146307179587, (float) 4.346063607179586, (float) 4.158280707179586, (float) 3.7659579071795863, (float) 3.2183681071795864, (float) 2.7686214, (float) 2.5554373, (float) 2.5066397, (float) 2.49274, (float) 2.5385504, (float) 2.672022, (float) 2.9793673, (float) 4.283122607179586, (float) 4.439760307179586, (float) 4.404535607179586, (float) 4.4218572071795865, (float) 4.414371207179586, (float) 4.358926307179586, (float) 4.256758307179586, (float) 4.040988507179586, (float) 3.6158491071795864, (float) 3.040103, (float) 2.5700078, (float) 2.3366914, (float) 2.2984695, (float) 2.2802548, (float) 2.3137858, (float) 2.482541, (float) 2.8900433, (float) 3.5823436071795864, (float) 4.199723807179586, (float) 4.367367407179586, (float) 4.3551255071795865, (float) 4.361216607179586, (float) 4.3316500071795865, (float) 4.187295307179586, (float) 3.9080811071795862, (float) 3.3923874071795863, (float) 2.8050108, (float) 2.4093044, (float) 2.2239122, (float) 2.1952786, (float) 2.209508, (float) 2.2573292, (float) 2.4057217, (float) 2.6752539, (float) 3.093407, (float) 3.7014597071795863, (float) 4.208100107179586, (float) 4.3240858071795865, (float) 4.293410007179586, (float) 4.279814307179587, (float) 4.202191607179586, (float) 3.9969233071795864, (float) 3.069152, (float) 2.5572054, (float) 2.2804813, (float) 2.193534, (float) 2.1740305, (float) 2.2017272, (float) 2.2725205, (float) 2.3621275, (float) 2.4369886, (float) 2.5901623, (float) 2.910371, (float) 3.3215311071795863, (float) 3.727893607179586, (float) 4.088892007179586, (float) 4.261269907179586, (float) 4.258217907179587, (float) 4.237507207179586, (float) 4.133903107179586, (float) 3.884146007179586, (float) 3.526502307179586, (float) 3.165523607179586, (float) 2.8625963, (float) 2.610641, (float) 2.441301, (float) 2.3047898, (float) 2.226632, (float) 2.2207725, (float) 2.3261914, (float) 2.6337273, (float) 3.1550813071795862, (float) 3.7575145071795863, (float) 4.145572007179586, (float) 4.239996507179587, (float) 4.195340507179586, (float) 4.172575107179586, (float) 3.7753923071795863, (float) 3.5156820071795862, (float) 3.397007807179586, (float) 3.2461446071795863, (float) 2.9238658, (float) 2.6271243, (float) 2.404878, (float) 2.236637, (float) 2.2522976, (float) 2.4858522, (float) 2.899359, (float) 3.4481388071795864};
//	private static double[] zs1_doubs = {2.514909, 2.5458746, 2.6469429, 2.8878028, 3.294381407179586, 3.8478001071795864, 4.327620907179586, 4.4459557071795865, 4.363974507179586, 4.306567307179586, 4.243871507179586, 4.043820407179586, 3.644182307179586, 3.1884142071795862, 2.9158187, 2.878709, 2.8712478, 2.856895, 2.8856266, 2.940194, 3.212277507179586, 3.756549207179586, 4.319415607179586, 4.552972507179586, 4.474068707179586, 4.430378107179586, 4.462398307179586, 4.369710607179586, 3.625023707179586, 3.1172192, 2.8414152, 2.7809196, 2.7839465, 2.800671, 2.7938335, 2.8378587, 3.0290337, 3.610400307179586, 4.299749307179586, 4.549540707179586, 4.442579307179586, 4.398001407179587, 4.457092507179587, 4.351394007179586, 4.047479407179586, 3.5441747071795864, 2.9527786, 2.5554326, 2.4418573, 2.4038644, 2.5507576, 2.8071609, 3.4445923071795863, 4.1785219071795865, 4.424250207179586, 4.392989707179586, 4.409736507179586, 4.418146307179587, 4.346063607179586, 4.158280707179586, 3.7659579071795863, 3.2183681071795864, 2.7686214, 2.5554373, 2.5066397, 2.49274, 2.5385504, 2.672022, 2.9793673, 4.283122607179586, 4.439760307179586, 4.404535607179586, 4.4218572071795865, 4.414371207179586, 4.358926307179586, 4.256758307179586, 4.040988507179586, 3.6158491071795864, 3.040103, 2.5700078, 2.3366914, 2.2984695, 2.2802548, 2.3137858, 2.482541, 2.8900433, 3.5823436071795864, 4.199723807179586, 4.367367407179586, 4.3551255071795865, 4.361216607179586, 4.3316500071795865, 4.187295307179586, 3.9080811071795862, 3.3923874071795863, 2.8050108, 2.4093044, 2.2239122, 2.1952786, 2.209508, 2.2573292, 2.4057217, 2.6752539, 3.093407, 3.7014597071795863, 4.208100107179586, 4.3240858071795865, 4.293410007179586, 4.279814307179587, 4.202191607179586, 3.9969233071795864, 3.069152, 2.5572054, 2.2804813, 2.193534, 2.1740305, 2.2017272, 2.2725205, 2.3621275, 2.4369886, 2.5901623, 2.910371, 3.3215311071795863, 3.727893607179586, 4.088892007179586, 4.261269907179586, 4.258217907179587, 4.237507207179586, 4.133903107179586, 3.884146007179586, 3.526502307179586, 3.165523607179586, 2.8625963, 2.610641, 2.441301, 2.3047898, 2.226632, 2.2207725, 2.3261914, 2.6337273, 3.1550813071795862, 3.7575145071795863, 4.145572007179586, 4.239996507179587, 4.195340507179586, 4.172575107179586, 3.7753923071795863, 3.5156820071795862, 3.397007807179586, 3.2461446071795863, 2.9238658, 2.6271243, 2.404878, 2.236637, 2.2522976, 2.4858522, 2.899359, 3.4481388071795864};
//	private static Float[] zs1_obj = Arrays.asList(zs1_doubs).toArray(new Float[zs1_doubs.length]);
//	float[] zs1 = ArrayUtils.toPrimitive(zs1_obj);

	private static float[] xs1 = {(float) 0.1674572, (float) 0.17189378, (float) 0.18607172, (float) 0.21788359, (float) 0.24859913, (float) 0.21961024, (float) 0.12505399, (float) 0.08346566, (float) 0.11749896, (float) 0.14202638, (float) 0.15657704, (float) 0.20130341, (float) 0.22291674, (float) 0.17835362, (float) 0.113587245, (float) 0.08665549, (float) 0.07878728, (float) 0.08407043, (float) 0.0948342, (float) 0.14524515, (float) 0.23204729, (float) 0.2646865, (float) 0.17921115, (float) 0.12254575, (float) 0.16166775, (float) 0.18927997, (float) 0.17357115, (float) 0.19552013, (float) 0.25989622, (float) 0.21599959, (float) 0.14398676, (float) 0.12565844, (float) 0.13311554, (float) 0.13891044, (float) 0.14780621, (float) 0.16975664, (float) 0.23635674, (float) 0.3008328, (float) 0.20842102, (float) 0.14580502, (float) 0.1844266, (float) 0.2134316, (float) 0.19989273, (float) 0.23227997, (float) 0.28525227, (float) 0.30255607, (float) 0.22725205, (float) 0.14839579, (float) 0.12707494, (float) 0.14207259, (float) 0.19957343, (float) 0.28522208, (float) 0.35545516, (float) 0.25675318, (float) 0.20627795, (float) 0.2613106, (float) 0.26998493, (float) 0.27106798, (float) 0.29119635, (float) 0.32812148, (float) 0.36631143, (float) 0.3158769, (float) 0.17734894, (float) 0.08194422, (float) 0.051662713, (float) 0.051192887, (float) 0.07491132, (float) 0.12885721, (float) 0.24305923, (float) 0.28367308, (float) 0.25714332, (float) 0.27733034, (float) 0.2753165, (float) 0.28210568, (float) 0.2955229, (float) 0.3118375, (float) 0.3372145, (float) 0.34400946, (float) 0.24450284, (float) 0.059541054, (float) 6.253833076179586, (float) 6.235486007179587, (float) 6.246524977179586, (float) 6.274765753179587, (float) 0.058154576, (float) 0.19767807, (float) 0.30461553, (float) 0.2576445, (float) 0.23197591, (float) 0.23968154, (float) 0.25336593, (float) 0.27611604, (float) 0.30560696, (float) 0.34155688, (float) 0.33879492, (float) 0.22331329, (float) 0.066665575, (float) 0.002986078, (float) 0.0060344706, (float) 0.024079623, (float) 0.055654462, (float) 0.112786934, (float) 0.21057938, (float) 0.32724002, (float) 0.3628724, (float) 0.29052863, (float) 0.27020732, (float) 0.28641987, (float) 0.29817498, (float) 0.32271472, (float) 0.36309746, (float) 0.35337114, (float) 0.17758517, (float) 0.052266043, (float) 0.028224818, (float) 0.036171604, (float) 0.05932795, (float) 0.08979623, (float) 0.12343131, (float) 0.15306805, (float) 0.2134381, (float) 0.30052653, (float) 0.35182425, (float) 0.33566034, (float) 0.2679298, (float) 0.22696267, (float) 0.23897202, (float) 0.25508595, (float) 0.28231055, (float) 0.32830837, (float) 0.3632402, (float) 0.34837577, (float) 0.273886, (float) 0.19064397, (float) 0.11987197, (float) 0.06895781, (float) 0.04354789, (float) 0.057195343, (float) 0.10510959, (float) 0.20945789, (float) 0.31649652, (float) 0.3181231, (float) 0.25951988, (float) 0.23596516, (float) 0.2534535, (float) 0.258865, (float) 0.31996194, (float) 0.34662026, (float) 0.35250935, (float) 0.3411388, (float) 0.2960888, (float) 0.21006836, (float) 0.12420242, (float) 0.06902088, (float) 0.101081274, (float) 0.19748253, (float) 0.3229677, (float) 0.39477476};
//	private static double[] xs1_doubs = {0.1674572, 0.17189378, 0.18607172, 0.21788359, 0.24859913, 0.21961024, 0.12505399, 0.08346566, 0.11749896, 0.14202638, 0.15657704, 0.20130341, 0.22291674, 0.17835362, 0.113587245, 0.08665549, 0.07878728, 0.08407043, 0.0948342, 0.14524515, 0.23204729, 0.2646865, 0.17921115, 0.12254575, 0.16166775, 0.18927997, 0.17357115, 0.19552013, 0.25989622, 0.21599959, 0.14398676, 0.12565844, 0.13311554, 0.13891044, 0.14780621, 0.16975664, 0.23635674, 0.3008328, 0.20842102, 0.14580502, 0.1844266, 0.2134316, 0.19989273, 0.23227997, 0.28525227, 0.30255607, 0.22725205, 0.14839579, 0.12707494, 0.14207259, 0.19957343, 0.28522208, 0.35545516, 0.25675318, 0.20627795, 0.2613106, 0.26998493, 0.27106798, 0.29119635, 0.32812148, 0.36631143, 0.3158769, 0.17734894, 0.08194422, 0.051662713, 0.051192887, 0.07491132, 0.12885721, 0.24305923, 0.28367308, 0.25714332, 0.27733034, 0.2753165, 0.28210568, 0.2955229, 0.3118375, 0.3372145, 0.34400946, 0.24450284, 0.059541054, 6.253833076179586, 6.235486007179587, 6.246524977179586, 6.274765753179587, 0.058154576, 0.19767807, 0.30461553, 0.2576445, 0.23197591, 0.23968154, 0.25336593, 0.27611604, 0.30560696, 0.34155688, 0.33879492, 0.22331329, 0.066665575, 0.002986078, 0.0060344706, 0.024079623, 0.055654462, 0.112786934, 0.21057938, 0.32724002, 0.3628724, 0.29052863, 0.27020732, 0.28641987, 0.29817498, 0.32271472, 0.36309746, 0.35337114, 0.17758517, 0.052266043, 0.028224818, 0.036171604, 0.05932795, 0.08979623, 0.12343131, 0.15306805, 0.2134381, 0.30052653, 0.35182425, 0.33566034, 0.2679298, 0.22696267, 0.23897202, 0.25508595, 0.28231055, 0.32830837, 0.3632402, 0.34837577, 0.273886, 0.19064397, 0.11987197, 0.06895781, 0.04354789, 0.057195343, 0.10510959, 0.20945789, 0.31649652, 0.3181231, 0.25951988, 0.23596516, 0.2534535, 0.258865, 0.31996194, 0.34662026, 0.35250935, 0.3411388, 0.2960888, 0.21006836, 0.12420242, 0.06902088, 0.101081274, 0.19748253, 0.3229677, 0.39477476};
//	private static Float[] xs1_obj = Arrays.asList(xs1_doubs).toArray(new Float[xs1_doubs.length]);
//	float[] xs1 = ArrayUtils.toPrimitive(xs1_obj);

	private static float[] ys1 = {(float) 1.7204796, (float) 1.7206365, (float) 1.7178807, (float) 1.6899968, (float) 1.6222245, (float) 1.4874098, (float) 1.3808241, (float) 1.3315989, (float) 1.3416139, (float) 1.3485792, (float) 1.3633865, (float) 1.4090955, (float) 1.5286703, (float) 1.672843, (float) 1.7624636, (float) 1.7909594, (float) 1.7906146, (float) 1.7945399, (float) 1.7781924, (float) 1.7728199, (float) 1.7334038, (float) 1.5382584, (float) 1.3542931, (float) 1.2812239, (float) 1.3064234, (float) 1.3333442, (float) 1.3329074, (float) 1.3509207, (float) 1.5361487, (float) 1.6833361, (float) 1.7692884, (float) 1.8080004, (float) 1.8010026, (float) 1.7873828, (float) 1.7777506, (float) 1.7808862, (float) 1.7363294, (float) 1.5613389, (float) 1.374256, (float) 1.294563, (float) 1.3244861, (float) 1.3425249, (float) 1.319693, (float) 1.3322412, (float) 1.4067771, (float) 1.5536281, (float) 1.7346367, (float) 1.8212212, (float) 1.850997, (float) 1.8545003, (float) 1.829342, (float) 1.761902, (float) 1.5589745, (float) 1.2809001, (float) 1.2038642, (float) 1.2117903, (float) 1.216083, (float) 1.2223442, (float) 1.2480044, (float) 1.304025, (float) 1.4461801, (float) 1.6650406, (float) 1.8183324, (float) 1.8716516, (float) 1.8884926, (float) 1.8861405, (float) 1.8715847, (float) 1.8452961, (float) 1.7799466, (float) 1.3068558, (float) 1.2601568, (float) 1.2544054, (float) 1.2547628, (float) 1.2622395, (float) 1.2804856, (float) 1.3046372, (float) 1.3660322, (float) 1.5210472, (float) 1.7482793, (float) 1.8670741, (float) 1.8902122, (float) 1.8963792, (float) 1.8810862, (float) 1.8628683, (float) 1.8472322, (float) 1.7891328, (float) 1.5612441, (float) 1.3432987, (float) 1.2984927, (float) 1.277817, (float) 1.2765164, (float) 1.2832235, (float) 1.3164363, (float) 1.3948747, (float) 1.565972, (float) 1.7739111, (float) 1.8676591, (float) 1.8895758, (float) 1.8984895, (float) 1.8897712, (float) 1.875651, (float) 1.8665267, (float) 1.8273776, (float) 1.7073232, (float) 1.4750136, (float) 1.2832857, (float) 1.2445562, (float) 1.2396255, (float) 1.2371656, (float) 1.2526181, (float) 1.3107625, (float) 1.6933781, (float) 1.8674461, (float) 1.9186633, (float) 1.9323045, (float) 1.9236985, (float) 1.9095744, (float) 1.8965802, (float) 1.8823072, (float) 1.8631414, (float) 1.8259101, (float) 1.7306685, (float) 1.5660204, (float) 1.413826, (float) 1.288753, (float) 1.2244694, (float) 1.2137123, (float) 1.2215306, (float) 1.2489607, (float) 1.3254932, (float) 1.4549773, (float) 1.6086409, (float) 1.7412337, (float) 1.8234006, (float) 1.8580648, (float) 1.8685104, (float) 1.8636602, (float) 1.8495988, (float) 1.8283641, (float) 1.7754878, (float) 1.6276119, (float) 1.4081705, (float) 1.2960523, (float) 1.2665887, (float) 1.2647514, (float) 1.2746432, (float) 1.372734, (float) 1.4699878, (float) 1.5151342, (float) 1.5690674, (float) 1.6801212, (float) 1.763268, (float) 1.8108939, (float) 1.8337215, (float) 1.837414, (float) 1.8132746, (float) 1.713477, (float) 1.510457};
//	private static double[] ys1_doubs = {1.7204796, 1.7206365, 1.7178807, 1.6899968, 1.6222245, 1.4874098, 1.3808241, 1.3315989, 1.3416139, 1.3485792, 1.3633865, 1.4090955, 1.5286703, 1.672843, 1.7624636, 1.7909594, 1.7906146, 1.7945399, 1.7781924, 1.7728199, 1.7334038, 1.5382584, 1.3542931, 1.2812239, 1.3064234, 1.3333442, 1.3329074, 1.3509207, 1.5361487, 1.6833361, 1.7692884, 1.8080004, 1.8010026, 1.7873828, 1.7777506, 1.7808862, 1.7363294, 1.5613389, 1.374256, 1.294563, 1.3244861, 1.3425249, 1.319693, 1.3322412, 1.4067771, 1.5536281, 1.7346367, 1.8212212, 1.850997, 1.8545003, 1.829342, 1.761902, 1.5589745, 1.2809001, 1.2038642, 1.2117903, 1.216083, 1.2223442, 1.2480044, 1.304025, 1.4461801, 1.6650406, 1.8183324, 1.8716516, 1.8884926, 1.8861405, 1.8715847, 1.8452961, 1.7799466, 1.3068558, 1.2601568, 1.2544054, 1.2547628, 1.2622395, 1.2804856, 1.3046372, 1.3660322, 1.5210472, 1.7482793, 1.8670741, 1.8902122, 1.8963792, 1.8810862, 1.8628683, 1.8472322, 1.7891328, 1.5612441, 1.3432987, 1.2984927, 1.277817, 1.2765164, 1.2832235, 1.3164363, 1.3948747, 1.565972, 1.7739111, 1.8676591, 1.8895758, 1.8984895, 1.8897712, 1.875651, 1.8665267, 1.8273776, 1.7073232, 1.4750136, 1.2832857, 1.2445562, 1.2396255, 1.2371656, 1.2526181, 1.3107625, 1.6933781, 1.8674461, 1.9186633, 1.9323045, 1.9236985, 1.9095744, 1.8965802, 1.8823072, 1.8631414, 1.8259101, 1.7306685, 1.5660204, 1.413826, 1.288753, 1.2244694, 1.2137123, 1.2215306, 1.2489607, 1.3254932, 1.4549773, 1.6086409, 1.7412337, 1.8234006, 1.8580648, 1.8685104, 1.8636602, 1.8495988, 1.8283641, 1.7754878, 1.6276119, 1.4081705, 1.2960523, 1.2665887, 1.2647514, 1.2746432, 1.372734, 1.4699878, 1.5151342, 1.5690674, 1.6801212, 1.763268, 1.8108939, 1.8337215, 1.837414, 1.8132746, 1.713477, 1.510457};
//	private static Float[] ys1_obj = Arrays.asList(ys1_doubs).toArray(new Float[ys1_doubs.length]);
//	float[] ys1 = ArrayUtils.toPrimitive(ys1_obj);
	
	private static float[] zs2 = new float[]{1, (float) 1.5, (float) 1.57};
	private static float[] xs2 = new float[]{2, (float) 2.5, (float) 2.52};
	private static float[] ys2 = new float[]{3, (float) 3.5, (float) 3.51};

	private static float[] zs3 = new float[]{1, (float) 1.5};
	private static float[] xs3 = new float[]{2, (float) 2.5};
	private static float[] ys3 = new float[]{3, (float) 3.5};
	
	@Test
	public void test1() {
//		SimpleDanceRecord sdr = new SimpleDanceRecord();
//		sdr.setQueue(new float[][]{zs2, xs2, ys2});
//		System.out.println(Arrays.deepToString(sdr.queue.toArray()));
//		System.out.println(Arrays.toString(sdr.getPositions(0)));
//		
//		SimpleDanceRecord sdr3 = new SimpleDanceRecord();
//		sdr3.setQueue(new float[][]{zs3, xs3, ys3});
//		System.out.println(Arrays.deepToString(sdr3.queue.toArray()));
//		System.out.println(Arrays.toString(sdr3.getPositions(0)));
//		
		SimpleDanceRecord sdr1 = new SimpleDanceRecord();
		sdr1.setQueue(new float[][]{zs1, xs1, ys1});
		System.out.println(Arrays.deepToString(sdr1.queue.toArray()));
		System.out.println(Arrays.toString(sdr1.getPositions(0)));	
		System.out.println("zs1 frequencies: " + Arrays.toString(sdr1.getFreqencies(0)));	
		System.out.println("xs1 frequencies: " + Arrays.toString(sdr1.getFreqencies(1)));	
		System.out.println("ys1 frequencies: " + Arrays.toString(sdr1.getFreqencies(2)));	
		
		double singleLadies = new Song(96, 2).getSamplesPerMove(40);
		System.out.println("samples per beyonce dance move: " + singleLadies);	

//		assert(false);
		
	}

}

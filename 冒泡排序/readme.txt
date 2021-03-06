该DEMO是一个冒泡排序：

冒泡排序算法的运作如下：（从后往前）
	比较相邻的元素。如果第一个比第二个大，就交换他们两个。
	对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
	针对所有的元素重复以上的步骤，除了最后一个。
	持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

时间复杂度：
	若文件的初始状态是正序的，一趟扫描即可完成排序。所需的关键字比较次数C和记录移动次数M均达到最小值：n-1，0。
	所以，冒泡排序最好的时间复杂度为 O(n)。
　　	若初始文件是反序的，需要进行n-1趟排序。每趟排序要进行n-i次关键字的比较(1≤i≤n-1)，且每次比较都必须移动记录三次来达到交换记录位置。在这种情况下，比较和移动次数均达到最大值:O(n^2),O(n^2)。
	冒泡排序的最坏时间复杂度为O(n^2)。
	综上，因此冒泡排序总的平均时间复杂度为 O(n^2)。

算法稳定性：
	冒泡排序就是把小的元素往前调或者把大的元素往后调。比较是相邻的两个元素比较，交换也发生在这两个元素之间。所以，如果两个元素相等，我想你是不会再无聊地把他们俩交换一下的；如果两个相等的元素没有相邻，那么即使通过前面的两两交换把两个相邻起来，这时候也不会交换，所以相同元素的前后顺序并没有改变，所以冒泡排序是一种稳定排序算法。


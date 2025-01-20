package class159;

// 美味，C++版
// 测试链接 : https://www.luogu.com.cn/problem/P3293
// 如下实现是C++的版本，C++版本和java版本逻辑完全一样
// 提交如下代码，可以通过所有测试用例

//#include <bits/stdc++.h>
//
//using namespace std;
//
//const int MAXN = 200001;
//const int MAXT = 4000001;
//const int BIT = 18;
//int n, m, s;
//int arr[MAXN];
//int root[MAXN];
//int ls[MAXT], rs[MAXT], size[MAXT];
//int cnt;
//
//int build(int l, int r) {
//    int rt = ++cnt;
//    size[rt] = 0;
//    if (l < r) {
//        int mid = (l + r) / 2;
//        ls[rt] = build(l, mid);
//        rs[rt] = build(mid + 1, r);
//    }
//    return rt;
//}
//
//int insert(int jobi, int l, int r, int i) {
//    int rt = ++cnt;
//    ls[rt] = ls[i];
//    rs[rt] = rs[i];
//    size[rt] = size[i] + 1;
//    if (l < r) {
//        int mid = (l + r) / 2;
//        if (jobi <= mid) {
//            ls[rt] = insert(jobi, l, mid, ls[rt]);
//        } else {
//            rs[rt] = insert(jobi, mid + 1, r, rs[rt]);
//        }
//    }
//    return rt;
//}
//
//int query(int jobl, int jobr, int l, int r, int u, int v) {
//    if (jobr < l || jobl > r) {
//        return 0;
//    }
//    if (jobl <= l && r <= jobr) {
//        return size[v] - size[u];
//    }
//    int mid = (l + r) / 2;
//    int ans = 0;
//    if (jobl <= mid) {
//        ans += query(jobl, jobr, l, mid, ls[u], ls[v]);
//    }
//    if (jobr > mid) {
//        ans += query(jobl, jobr, mid + 1, r, rs[u], rs[v]);
//    }
//    return ans;
//}
//
//void prepare() {
//    cnt = 0;
//    s = 0;
//    for (int i = 1; i <= n; i++) {
//        s = max(s, arr[i]);
//    }
//    root[0] = build(0, s);
//    for (int i = 1; i <= n; i++) {
//        root[i] = insert(arr[i], 0, s, root[i - 1]);
//    }
//}
//
//int compute(int b, int x, int l, int r) {
//    int ans = 0;
//    for (int i = BIT; i >= 0; i--) {
//        if (((b >> i) & 1) == 1) {
//            if (query(ans - x, ans - x + (1 << i) - 1, 0, s, root[l - 1], root[r]) == 0) {
//                ans += 1 << i;
//            }
//        } else {
//            if (query(ans - x + (1 << i), ans - x + (1 << (i + 1)) - 1, 0, s, root[l - 1], root[r]) != 0) {
//                ans += 1 << i;
//            }
//        }
//    }
//    return ans ^ b;
//}
//
//int main() {
//    ios::sync_with_stdio(false);
//    cin.tie(nullptr);
//    cin >> n >> m;
//    for (int i = 1; i <= n; i++) {
//        cin >> arr[i];
//    }
//    prepare();
//    for (int i = 1, b, x, l, r; i <= m; i++) {
//        cin >> b >> x >> l >> r;
//        cout << compute(b, x, l, r) << "\n";
//    }
//    return 0;
//}
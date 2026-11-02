# Sauce Demo Mobile — Katalon Automation 📱

> Otomasi UI aplikasi Android **[Sauce Labs My Demo App](https://github.com/saucelabs/my-demo-app-android)** menggunakan **Katalon Studio + Appium**. **109 test case** di 11 modul, 144 test object, 10 test suite + 4 test suite collection.

![Katalon](https://img.shields.io/badge/Katalon_Studio-11.6.0-4DBB4C?style=flat-square)
![Appium](https://img.shields.io/badge/Appium-3.7.0-662D91?style=flat-square)
![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?style=flat-square&logo=android&logoColor=white)
![Test Cases](https://img.shields.io/badge/Test_Cases-109-B42318?style=flat-square)
![Bugs](https://img.shields.io/badge/Defects_Documented-9-D97706?style=flat-square)

## 📥 APK yang Digunakan

Aplikasi yang diuji: **Sauce Labs My Demo App** (package `com.saucelabs.mydemoapp.android`, versi 2.3.0).

```
https://github.com/saucelabs/my-demo-app-android/releases
```

Unduh file `sauce-demo.apk` dari halaman release, lalu install ke perangkat/emulator:

```bash
adb install -r sauce-demo.apk
```

---

## ✨ Highlight Utama

### 1. 109 test case mobile di 11 modul — alur e-commerce penuh dari splash sampai order sukses

Mencakup jalur lengkap aplikasi: **Splash → Login → Katalog → Sort → Detail Produk → Keranjang → Checkout (alamat & pembayaran) → Review → Place Order → Checkout Complete**, ditambah seluruh fitur pada hamburger menu (WebView, QR Code Scanner, Geo Location, Drawing, Biometrik, About, Logout & Reset App State). Setiap test case punya prasyarat, langkah, dan hasil yang diharapkan eksplisit — bukan sekadar script yang jalan.

### 2. 9 defect terdokumentasi + suite khusus "Known Bugs" sebagai penjaga regresi terbalik

Sembilan test case bertanda `(BUG)` dikumpulkan pada suite **`06. TS-Known Bugs`** (dan collection `14. TSC-Known Bugs`). Suite ini **meng-assert perilaku rusak yang sedang terjadi** — begitu developer memperbaiki bug, suite berubah **merah** dan memberi sinyal bahwa test perlu diperbarui. Sebaliknya bila bug kembali muncul, suite jadi hijau.

### 3. Keyword mobile asli + simulasi gesture berbasis koordinat elemen

Tidak memakai XPath rapuh. Semua interaksi memakai `Mobile.tap`, `Mobile.setText`, `Mobile.scrollToText`, `Mobile.doubleTap`, `Mobile.pressBack`, `Mobile.hideKeyboard` terhadap 144 test object dengan locator stabil. Untuk fitur Drawing, koordinat swipe dihitung dari bounding box elemen (`getElementLeftPosition` / `TopPosition` / `Width` / `Height`) sehingga simulasi goresan tetap akurat di berbagai ukuran layar.

---

## 📊 Statistik Proyek

| Metrik | Jumlah |
|--------|:------:|
| Test case | **109** |
| Modul / grup | **11** |
| Test object (Object Repository) | **144** |
| Test suite | **10** |
| Test suite collection | **4** |
| Test case bertanda BUG | **9** |
| Perangkat uji | Xiaomi M2101K7BNY — Android 13 |

---

## 📦 Cakupan Modul

| Modul | Test Case | Cakupan |
|-------|:---------:|---------|
| **Login** | 12 | Kredensial valid/invalid, field kosong, user terkunci (`alice@example.com`), autofill, password tersembunyi, double tap |
| **Detail Produk** | 10 | Info produk, rating, warna, tombol +/−, add to cart, badge keranjang, tombol back |
| **Payment** | 10 | Form kartu, validasi Card Number / Expiration Date / CVV, checkbox billing, tip CVV |
| **Cart** | 10 | Daftar item, total, ubah qty, hapus item, empty state, persistensi setelah app ditutup |
| **Checkout Alamat** | 9 | Field wajib, field opsional, format zip code, field spasi, back dari pembayaran |
| **Place Order** | 7 | Ringkasan order, biaya kirim $5.99, total = subtotal + ongkir, place order berulang |
| **Catalog** | 7 | Grid produk, judul, jumlah item, scroll, gambar, tanpa internet |
| **Sort** | 6 | Dialog sort, urut nama A-Z & Z-A, urut harga naik & turun, indikator opsi aktif |
| **Splash** | 3 | Splash tampil, tidak freeze, tidak muncul saat app sudah terbuka |
| **Checkout Complete** | 3 | Pesan sukses, continue shopping, keranjang kosong setelah order |
| **Hamburger Menu** | 32 | Drawer (6), Biometrik (4), Logout & Reset (4), Geo Location (5), WebView (5), Drawing (3), QR Code (3), About (2) |

**Total: 109 test case**

---

## 🗂 Test Suite & Collection

| # | Nama | Tipe | Isi |
|:-:|------|------|-----|
| 01 | TS-Smoke | Suite | 11 test case jalur kritis end-to-end |
| 02 | TS-Auth | Suite | 11 test case autentikasi |
| 03 | TS-Shopping | Suite | 26 test case katalog sampai keranjang |
| 04 | TS-Content | Suite | 17 test case verifikasi konten & elemen |
| 05 | TS-Non Functional | Suite | 9 test case perilaku & batas |
| 06 | TS-Known Bugs | Suite | 9 test case defect terdokumentasi |
| 07 | TS-E2E | Suite | 3 test case akhir alur order |
| 08 | TS-Checkout | Suite | 19 test case checkout lengkap |
| 09 | TS-Negative | Suite | 26 test case skenario negatif |
| 10 | TS-Hamburger Menu | Suite | 32 test case fitur menu samping |
| 11 | TSC-Regression | Collection | Suite 02, 03, 04, 05, 08 |
| 12 | TSC-Smoke Gate | Collection | Suite 01 saja (gate cepat) |
| 13 | TSC-E2E Only | Collection | Suite 07 saja |
| 14 | TSC-Known Bugs | Collection | Suite 06 saja |

Satu klik pada **Test Suite Collection** menjalankan seluruh rangkaian. `TSC-Smoke Gate` dipakai sebagai gerbang cepat sebelum regresi penuh.

---

## 🐛 Defect Terdokumentasi

| # | Modul | Test Case | Perilaku yang Diuji |
|:-:|-------|-----------|---------------------|
| 1 | Login | TC-006 Login dengan password salah | Validasi password salah |
| 2 | Login | TC-010 Login dengan username panjang | Input username sangat panjang |
| 3 | Catalog | TC-006 Gambar produk tanpa internet | Handling gambar saat offline |
| 4 | Cart | TC-009 Isi keranjang bertahan setelah app ditutup | Persistensi keranjang |
| 5 | Checkout Alamat | TC-007 Zip Code format tidak valid | Validasi format zip code |
| 6 | Payment | TC-003 Card Number tidak valid | Validasi nomor kartu |
| 7 | Payment | TC-005 Expiration Date tidak valid | Validasi tanggal kedaluwarsa |
| 8 | Payment | TC-006 Security Code tidak valid | Validasi CVV |
| 9 | Payment | TC-007 Info CVV tampil | Ketersediaan teks bantuan CVV |

Semua dijalankan lewat `06. TS-Known Bugs` — suite yang sengaja dibuat merah saat ini dan akan hijau ketika bug diperbaiki.

---

## 🛠 Tech Stack

| Komponen | Versi / Keterangan |
|----------|--------------------|
| Katalon Studio | 11.6.0 (Enterprise project, tipe **MOBILE**) |
| Appium Server | 3.7.0 |
| Driver | `uiautomator2` 8.6.3 |
| Platform | Android (minSdk 21, targetSdk 31) |
| Bahasa script | Groovy |
| Perangkat uji | Xiaomi M2101K7BNY — Android 13 |
| Keyword | `Mobile.tap`, `Mobile.setText`, `Mobile.verifyElementExist`, `Mobile.scrollToText`, `Mobile.swipe`, `Mobile.doubleTap`, `Mobile.pressBack`, `Mobile.hideKeyboard`, `Mobile.getText`, `Mobile.verifyMatch` |

Capabilities yang dipakai: `platformName=ANDROID`, `automationName=uiautomator2`, `autoGrantPermissions=true`, `newCommandTimeout=1800`.

---

## 🚀 Cara Menjalankan

### 1. Prasyarat

```bash
# Node.js & Appium
npm install -g appium
appium driver install uiautomator2

# Cek instalasi
appium driver list --installed
```

- Katalon Studio 11.x terpasang
- Android SDK + `adb` tersedia di PATH
- Perangkat fisik / emulator terhubung (`adb devices` mengembalikan device)

### 2. Install aplikasi

```bash
# Unduh APK dari halaman release Sauce Labs
# https://github.com/saucelabs/my-demo-app-android/releases
adb install -r sauce-demo.apk
```

### 3. Atur Global Variable

Buka `Profiles/default.glbl` dan sesuaikan:

| Variable | Nilai | Keterangan |
|----------|-------|------------|
| `apkPath` | path file `sauce-demo.apk` | Dipakai untuk start aplikasi yang belum terpasang |
| `apkPackage` | `com.saucelabs.mydemoapp.android` | Dipakai untuk start aplikasi yang sudah terpasang |

### 4. Jalankan Appium

```bash
appium --base-path /wd/hub
```

### 5. Jalankan test

- **Lewat GUI:** buka project di Katalon Studio → pilih Test Suite / Test Suite Collection → **Run**
- **Lewat CLI (headless):**

```bash
# Smoke gate (cepat — 11 test case)
katalon -noSplash -runMode=console \
  -projectPath="Sauce Demo Mobile.prj" \
  -testSuiteCollectionPath="Test Suites/12. TSC-Smoke Gate" \
  -executionProfile=default

# Regresi penuh
katalon -noSplash -runMode=console \
  -projectPath="Sauce Demo Mobile.prj" \
  -testSuiteCollectionPath="Test Suites/11. TSC-Regression" \
  -executionProfile=default
```

> Linux/macOS: ganti `katalon` dengan `./katalon` sesuai lokasi instalasi.

---

## 🗂 Struktur Project

```
saucedemo-mobile-katalon/
├── Scripts/                      109 script Groovy (test case)
│   ├── Splash/                   (3)
│   ├── Login/                    (12)
│   ├── Catalog/                  (7)
│   ├── Sort/                     (6)
│   ├── Detail Produk/            (10)
│   ├── Cart/                     (10)
│   ├── Checkout Alamat/          (9)
│   ├── Payment/                  (10)
│   ├── Place Order/              (7)
│   ├── Checkout Complete/        (3)
│   └── 0. Hamburger/             (32)
│       ├── Drawer/  Biometrik/  Logout And Reset/
│       ├── Geo Location/  WebView/  Drawing/
│       └── QR Code/  About/
├── Test Cases/                   109 test case (metadata)
├── Object Repository/            144 test object
│   ├── Main Menu/                Catalog, Detail Product, Cart, Sort, Hamburger
│   ├── Hamburger Click/          Webview, QR Code, Geo Location, Drawing, About,
│   │                             Reset App State, Finger Print, Crash App,
│   │                             Login, Logout
│   └── Splash/
├── Test Suites/                  10 suite + 4 collection
├── Profiles/default.glbl         GlobalVariable: apkPath, apkPackage
├── Include/config/               log.properties
├── appium.log                    Log sesi Appium (bukti eksekusi)
├── build.gradle                  Katalon Gradle plugin 0.2.0
└── Sauce Demo Mobile.prj         Project Katalon (tipe MOBILE)
```

---

## 🔍 Catatan Desain

1. **Locator berbasis accessibility ID / resource-id** — 144 test object, tanpa XPath posisi, sehingga tahan perubahan layout.
2. **Setiap test case independen** — diawali `Mobile.startExistingApplication()` dan diakhiri `Mobile.closeApplication()`, jadi bisa dijalankan terpisah atau berurutan.
3. **Pemisahan suite per tujuan** — Smoke untuk gate cepat, Regression untuk cakupan penuh, Known Bugs terpisah agar tidak mengaburkan hasil regresi.
4. **Gesture dihitung relatif terhadap elemen** — fitur Drawing memakai bounding box, bukan koordinat hardcoded per device.
5. **`autoGrantPermissions=true`** — dialog permission (kamera, lokasi) tidak memblokir eksekusi otomatis.

---

## 👤 Author

**Fachri Alhadi Ramadhan**

- GitHub: [@fachrialhadiramadhan](https://github.com/fachrialhadiramadhan)
- Repository: [saucedemo-mobile-katalon](https://github.com/fachrialhadiramadhan/saucedemo-mobile-katalon)
- Aplikasi yang diuji: [Sauce Labs My Demo App](https://github.com/saucelabs/my-demo-app-android/releases)

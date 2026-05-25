# Implementasi Suffix Tree dan DAWG untuk Smart Dictionary (Java)

### Mata Kuliah
Struktur Data dan Pemrograman Berorientasi Objek

### Dosen Pengampu
Hafara Firdausi, S. Kom, M.Kom

---

## Anggota Kelompok

| NRP | Nama |
|---|---|
| 5027251018 | Nazwa Aulia Dwi Purnomo |
| 5027251048 | M. Faris Roisul Azhar |
| 5027251045 | Ahmad Nayottama Juliansyah |
| 5027251008 | Silfi Rochmatul Auliyah |
| 5027251129 | Dafa Ridho Zhafif |

# Daftar Isi

1. Problem Statement / Permasalahan
2. Penjelasan Struktur Tree dan Algoritma
3. Diagram / Visualisasi
4. Aplikasi / Implementasi
5. Keunggulan
6. Kekurangan
7. Perbandingan Tree Dasar dan Modifikasi
8. Analisis Kompleksitas
9. Potensi Pengembangan
10. Hasil Implementasi
11. Perbandingan Performa Real
12. Kesimpulan
13. Referensi

---

## 1. Problem Statement / Permasalahan
Dikerjakan oleh: Nazwa

#### 1.1 Latar Belakang
Isi:
- pentingnya substring searching
- autocomplete
- dictionary modern
- efisiensi pencarian data
- penggunaan struktur tree

#### 1.2 Rumusan Masalah

Contoh:
1. Bagaimana implementasi Suffix Tree?
2. Bagaimana implementasi DAWG?
3. Bagaimana perbandingan performa keduanya?
4. Bagaimana penerapan smart dictionary?

#### 1.3 Tujuan

Contoh:
- memahami struktur tree
- mengimplementasikan suffix tree dan DAWG
- membandingkan performa
- membuat simulasi smart dictionary

## 2. Penjelasan Struktur Tree dan Algoritma

#### 2.1 Suffix Tree

Dikerjakan oleh: Nazwa

##### Definisi

Penjelasan mengenai:
- apa itu suffix tree
- fungsi suffix tree
- penggunaan dalam substring searching

##### Struktur Node

Penjelasan:
- child
- sibling
- traversal

##### Cara Kerja

Contoh:

```txt
teknologi
eknologi
knologi
...
````

##### Algoritma Insertion

Penjelasan:

* insert suffix
* traversal karakter
* pencarian child node

##### Search Substring

Penjelasan:

* traversal berdasarkan karakter
* pencarian pattern

##### Kompleksitas

| Operasi    | Kompleksitas |
| ---------- | ------------ |
| Build Tree | O(n²)        |
| Search     | O(m)         |

#### 2.2 DAWG (Directed Acyclic Word Graph)

Dikerjakan oleh: Silfi

##### Definisi

Penjelasan mengenai:

* DAWG
* automata
* directed graph

##### Konsep Automata

Penjelasan:

* state
* transition
* accept state

##### State Minimization

Penjelasan:

* penggabungan state
* efisiensi memori

##### Hubungan dengan Suffix Tree

Perbedaan:

* tree vs automata
* node vs state
* memori

##### Search Recognition

Penjelasan:

* traversal transition
* substring recognition

##### Kompleksitas

| Operasi | Kompleksitas      |
| ------- | ----------------- |
| Build   | O(n) - O(n log n) |
| Search  | O(m)              |

## 3. Diagram / Visualisasi

Dikerjakan oleh: Julian

#### 3.1 Diagram Suffix Tree

Isi:

* visualisasi tree
* output traversal

Contoh:

```txt id="c0d0ez"
ROOT
└── t
    └── e
        └── k
```

#### 3.2 Diagram DAWG

Isi:

* state transition
* graph automata

Contoh:

```txt id="6h2k0w"
(q0) --t--> (q1)
```

#### 3.3 Diagram Alur Program

Contoh:

```txt id="g6jnyu"
Input
 ↓
Build Structure
 ↓
Search
 ↓
Output
```

## 4. Aplikasi / Implementasi

Dikerjakan oleh: Dafa

#### Deskripsi Program

Penjelasan smart dictionary.

#### Bahasa Pemrograman

Java

#### Struktur File

| File               | Fungsi                    |
| ------------------ | ------------------------- |
| TreeNode.java      | Struktur node suffix tree |
| SuffixTree.java    | Implementasi suffix tree  |
| State.java         | Struktur state DAWG       |
| DAWG.java          | Implementasi DAWG         |
| DictionaryApp.java | Fitur dictionary          |
| Benchmark.java     | Benchmark                 |
| Visualizer.java    | Visualisasi               |
| Main.java          | Integrasi                 |

#### Fitur Program

Penjelasan:

* searchWord()
* substringSearch()
* autocomplete()
* suggested word

#### Alur Program

Contoh:

```txt id="vy4bca"
Input Kata
 ↓
Search
 ↓
Output Hasil
```

## 5. Keunggulan

Dikerjakan oleh: Julian

#### 5.1 Keunggulan Suffix Tree

Isi:

* search cepat
* traversal sederhana
* substring searching efisien

#### 5.2 Keunggulan DAWG

Isi:

* hemat memori
* state lebih sedikit
* minimization

## 6. Kekurangan

Dikerjakan oleh: Nazwa

#### 6.1 Kekurangan Suffix Tree

Isi:

* node banyak
* memori besar
* build cukup kompleks

#### 6.2 Kekurangan DAWG

Isi:

* implementasi sulit
* automata lebih kompleks

## 7. Perbandingan Tree Dasar dan Modifikasi Secara Teori

Dikerjakan oleh: Silfi

| Aspek        | Suffix Tree | DAWG        |
| ------------ | ----------- | ----------- |
| Struktur     | Tree        | Automata    |
| Memori       | Besar       | Lebih hemat |
| Search       | Cepat       | Cepat       |
| Kompleksitas | Sedang      | Tinggi      |

#### Analisis Teori

Penjelasan:

* perbedaan struktur
* efisiensi state
* penggunaan memori
* traversal

## 8. Analisis Kompleksitas Berdasarkan Struktur Tree

Dikerjakan oleh: Faris

#### 8.1 Kompleksitas Suffix Tree

Penjelasan:

* insertion
* traversal
* search

#### 8.2 Kompleksitas DAWG

Penjelasan:

* state transition
* minimization
* substring recognition

#### 8.3 Analisis Efisiensi

Isi:

* search complexity
* memory complexity
* traversal efficiency

## 9. Potensi Pengembangan ke Depan

Dikerjakan oleh: Julian

Isi:

* spell checker
* recommendation system
* search engine
* NLP
* text mining
* autocomplete modern

## 10. Hasil Implementasi

Dikerjakan oleh: Nazwa, Silfi, Dafa

#### 10.1 Hasil Suffix Tree (Nazwa)

Masukkan:

* output search
* traversal tree

Contoh:

```txt id="4m6k2j"
Search 'log' : true
Search 'tek' : true
```

#### 10.2 Hasil DAWG (Silfi)

Masukkan:

* transition result
* automata traversal

#### 10.3 Hasil Dictionary (Dafa)

Masukkan:

* autocomplete
* suggested word
* substring search

## 11. Perbandingan Performa Real (Benchmark)

Dikerjakan oleh: Faris

#### 11.1 Dataset

* 1000 kata
* 5000 kata
* 10000 kata

#### 11.2 Benchmark

| Dataset    | Linear Search | Suffix Structure |
| ---------- | ------------- | ---------------- |
| 1000 kata  | ...           | ...              |
| 5000 kata  | ...           | ...              |
| 10000 kata | ...           | ...              |

#### 11.3 Analisis Benchmark

Penjelasan:

* suffix tree lebih cepat
* DAWG lebih efisien
* traversal karakter lebih optimal

## 12. Kesimpulan

Dikerjakan oleh: Silfi

Isi:

* hasil implementasi
* efisiensi struktur data
* perbandingan performa
* penggunaan tree pada smart dictionary

## 13. Referensi

Dikerjakan oleh: Nazwa

Isi:

1. Paper Suffix Tree
2. Paper DAG

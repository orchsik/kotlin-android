# kotlin-android

### 개발환경

- JDK 8 이상
- Android Studio 4 이상

---

### 개발 편의 기능 사용 추가

- 앱레벨 Gradle File 수정 ( ./app/build.gradle )

```gradle
android {
   ...
   buildFeatures {
       viewBinding true
   }
}
```

- Activity에서 뷰 결합 사용

```Kotlin
// # bindingClassName: The name of this binding class is
// the name of the XML file in Pascal case
// with the word Binding added to the end.
private lateinit var binding: {bindingClassName}

override fun onCreate(savedInstanceState: Bundle) {
   super.onCreate(savedInstanceState)
   binding = {bindingClassName}.inflate(layoutInflater)
   val view = binding.root
   setContentView(view)

   binding.name.text = viewModel.name
   binding.button.setOnClickListener { viewModel.userClicked() }
}
```

- Fragment에서 뷰 결합 사용

```Kotlin
 private var _binding: {bindingClassName}? = null
 // This property is only valid between onCreateView and
 // onDestroyView.
 private val binding get() = _binding!!

 override fun onCreateView(
     inflater: LayoutInflater,
     container: ViewGroup?,
     savedInstanceState: Bundle?
 ): View? {
     _binding = {bindingClassName}.inflate(inflater, container, false)
     val view = binding.root
     return view
 }

 override fun onDestroyView() {
     super.onDestroyView()
     _binding = null
 }
```

- depreceated

```gradle
plugins {
  ...
  id 'kotlin-android-extensions'
}
```

---

## 진행순서

1. HelloView
2. HelloAdapterView
3. HelloMenu

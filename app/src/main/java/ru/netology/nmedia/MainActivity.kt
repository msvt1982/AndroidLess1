package ru.netology.nmedia

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.supportingFunctions.converterNumToString


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            published = "21 мая в 18:36",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb"
        )

        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            likeCount.text = converterNumToString(post.likes)
            shareCount.text = converterNumToString(post.share)
            viewsCount.text = converterNumToString(post.postViews)
            if (post.likedByMe) {
                like.setImageResource(R.drawable.ic_liked_24)
            }

            like.setOnClickListener {
                post.likedByMe = !post.likedByMe

                like.setImageResource(
                    if (post.likedByMe) {
                        post.likes++
                        likeCount.text = converterNumToString(post.likes)
                        R.drawable.ic_liked_24
                    } else {
                        post.likes--
                        likeCount.text = converterNumToString(post.likes)
                        R.drawable.ic_like_24
                    }
                )
            }

            share.setOnClickListener{
                post.share++
                shareCount.text = converterNumToString(post.share)
            }
        }

    }
}
package ru.netology.nmedia.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.supportingFunctions.converterNumToString
import ru.netology.nmedia.viewmodel.PostViewModel


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel: PostViewModel by viewModels()
        viewModel.data.observe(this) { post ->
            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                likeCount.text = converterNumToString(post.likes)
                shareCount.text = converterNumToString(post.share)
                viewsCount.text = converterNumToString(post.postViews)
                like.setImageResource(
                    if (post.likedByMe) {
                        likeCount.text = converterNumToString(post.likes)
                        R.drawable.ic_liked_24
                    } else {
                        likeCount.text = converterNumToString(post.likes)
                        R.drawable.ic_like_24
                    }
                )
            }

            binding.like.setOnClickListener {
                viewModel.like()
            }

            binding.share.setOnClickListener {
                viewModel.share()
            }
        }
    }
}
class node(object):
    """docstring for node"""
    def __init__(self):
        self.is_end = False
        self.next_ls = [None] * 26


class Trie:
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = node()

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        cur_node = self.root
        for val in word:
            index = ord(val) - ord("a")
            if isinstance(cur_node.next_ls[index], node):
                cur_node = cur_node.next_ls[index]
            else:
                cur_node.next_ls[index] = node()
                cur_node = cur_node.next_ls[index]
        cur_node.is_end = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        cur_node = self.root
        for val in word:
            index = ord(val) - ord("a")
            if isinstance(cur_node.next_ls[index], node):
                cur_node = cur_node.next_ls[index]
            else:
                return False
        return cur_node.is_end == True

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        cur_node = self.root
        for val in prefix:
            index = ord(val) - ord("a")
            if isinstance(cur_node.next_ls[index], node):
                cur_node = cur_node.next_ls[index]
            else:
                return False
        return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)